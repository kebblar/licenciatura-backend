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

import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Login;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.utils.DigestEncoder;
import mx.unam.backend.utils.EnumMessage;
import mx.unam.backend.utils.JWTUtil;

/**
 * <p>Implementación de la interfaz {@link mx.unam.backend.service.LoginService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author  garellano, mentesniker
 * @see     unam.mx.backend.domain.Usuario
 * @see     mx.unam.backend.service.LoginService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class LoginServiceImpl implements LoginService{

    private UsuarioMapper usuarioMapper;

    public LoginServiceImpl(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    /** {@inheritDoc} */
    @Override
    public Login login(CredencialesRequest usuario) throws ControllerException {

        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        //Usuario no existente
        if(usuario.getMail()==null) throw new CustomException(EnumMessage.BAD_CREDENTIALS);

        Usuario validUser = usuarioMapper.getbyMail(usuario.getMail());

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
    
}