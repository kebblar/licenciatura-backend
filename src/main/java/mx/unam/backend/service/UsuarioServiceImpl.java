/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      LoginServiceImpl
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Login;
import mx.unam.backend.model.RecuperacionTokenRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.utils.DigestEncoder;
import mx.unam.backend.utils.EnumMessage;
import mx.unam.backend.utils.JWTUtil;
import mx.unam.backend.utils.StringUtils;

/**
 * <p>Implementación de la interfaz {@link mx.unam.backend.service.UsuarioService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author  garellano, mentesniker
 * @see     unam.mx.backend.domain.Usuario
 * @see     mx.unam.backend.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioMapper usuarioMapper;
    private final MailSenderService mailSenderService;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, MailSenderService mailSenderService) {
        this.usuarioMapper = usuarioMapper;
        this.mailSenderService = mailSenderService;
    }

    /** {@inheritDoc} */
    @Override
    public Login login(CredencialesRequest usuario) throws ControllerException {

        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        //Usuario no existente
        if(usuario.getMail()==null) throw new CustomException(EnumMessage.BAD_CREDENTIALS);

        Usuario validUser = usuarioMapper.getByMail(usuario.getMail());

        if(validUser==null) throw new CustomException(EnumMessage.BAD_CREDENTIALS);

        if(!validUser.isActivo()) throw new CustomException(EnumMessage.DISABLED_USER);

        //Usuario bloqueado
        long instanteDeBloqueo = validUser.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) {
            long totalSegundos = restante/1000;
            long totalMinutos = totalSegundos/60;
            throw new CustomException(EnumMessage.WAIT_LOGIN, totalMinutos, totalSegundos%60);
        }
        
        //Clave incorrecta
        String passwordHasheado = DigestEncoder.digest(usuario.getClave(), usuario.getMail());
        if(!passwordHasheado.equals(validUser.getClave())){
            int numeroDeIntentosFallidos = validUser.getAccesoNegadoContador()+1;
            validUser.setAccesoNegadoContador(numeroDeIntentosFallidos);
            usuarioMapper.update(validUser);

            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                validUser.setInstanteBloqueo(instanteActual); 
                throw new CustomException(EnumMessage.MAX_FAILED_LOGIN_EXCEPTION, maximoNumeroIntentosConcedidos);
            }

            throw new CustomException(EnumMessage.BAD_CREDENTIALS, numeroDeIntentosFallidos, maximoNumeroIntentosConcedidos);

        }

        // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y retorna el usuario:
        validUser.setAccesoNegadoContador(0);
        validUser.setInstanteBloqueo(0);
        validUser.setInstanteUltimoAcceso(instanteActual);
        usuarioMapper.update(validUser);

        Login loginResponse = new Login();
        String encryptKey = "secreto";
        loginResponse.setMail(validUser.getMail());
        String jwt = JWTUtil.getInstance().createToken(usuario.getMail(), 27, encryptKey);
        loginResponse.setJwt(jwt);
        loginResponse.setRoles(usuarioMapper.getRoles(validUser.getMail()));
        return loginResponse;
    }

    /** {@inheritDoc} */
    @Override
    public Usuario solicitaRegeneracionClave(String correo) throws ServiceException {
        String token = StringUtils.getRandomString(6);
        Usuario usuario = usuarioMapper.getByMail(correo);
        if(usuario!=null){
            usuario.setRegeneraClaveInstante(System.currentTimeMillis());
            usuario.setRegeneraClaveToken(token);
            usuarioMapper.update(usuario);
            sendMail("Estimado Usuario", correo, token, "Clave de recuperación");
            return usuario;
        }
        return new Usuario(0, "", "", 0, false, 0, 0, 0, 0, "", 0);
    }

    /** {@inheritDoc} */
    @Override
    public Usuario confirmaRegeneraClave(RecuperacionTokenRequest tokenRequest) throws ServiceException {
        validate(tokenRequest.getClaveNueva());
        long unaHora = 1000*60*60L;
        Usuario usuario = usuarioMapper.getByToken(tokenRequest.getToken());
        if(usuario==null) throw new CustomException(EnumMessage.TOKEN_NOT_EXIST);
        if(!tokenRequest.getToken().equals(usuario.getRegeneraClaveToken())) throw new CustomException(EnumMessage.TOKEN_NOT_EXIST);
        long remaining = System.currentTimeMillis()-usuario.getRegeneraClaveInstante();
        if(remaining<unaHora) {
            String claveHash = DigestEncoder.digest(tokenRequest.getClaveNueva(), usuario.getMail());
            usuario.setClave(claveHash);
            usuario.setRegeneraClaveToken(tokenRequest.getToken());
            usuarioMapper.update(usuario);
            return usuario;
        } else {
            throw new CustomException(EnumMessage.TOKEN_EXPIRED);
        }
    }

    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body= String.format("<h1>Hola %s. Tu clave de acceso es %s y tiene una validez de %d minutos. (body auxiliar) </h1>", nick, randomString, 10);
        this.mailSenderService.sendHtmlMail(correo, titulo, body);
    }

    private void validate(String clave) throws CustomException{
        //8 and 16 characters
        if(clave.length()< 8 || clave.length() > 16){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Introducir una clave de 8 hasta 16 caracteres.");
        }
        //Rule 2: No whitespace allowed
        if(clave.contains(" ")){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Remover espacios en blanco.");
        }
        //Rule 3: At least one Upper-case character
        if(!clave.matches("^(?=.*[A-Z]).+$")){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar una mayuscula a la clave.");
        }
        //Rule 4: At least one Lower-case character
        if(!clave.matches("^(?=.*[a-z]).+$")){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar una minuscula a la clave.");
        }
        //Rule 5: At least one digit
        if(!clave.matches("^(?=.*\\d).+$")){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar un numero a la clave.");
        }
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(clave);
        //Rule 5: At least one special character
        if(!hasSpecial.find()){
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar un caracter especial a la clave.");
        }
    }
    
}