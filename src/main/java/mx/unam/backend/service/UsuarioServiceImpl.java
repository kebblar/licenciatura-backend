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

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.RegistroMapper;
import mx.unam.backend.mapper.UsuarioDetalleMapper;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Login;
import mx.unam.backend.model.Preregistro;
import mx.unam.backend.model.RecuperacionTokenRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.model.UsuarioDetalle;
import mx.unam.backend.utils.DigestEncoder;
import mx.unam.backend.utils.EnumMessage;
import mx.unam.backend.utils.HttpStatus;
import mx.unam.backend.utils.JWTUtil;
import mx.unam.backend.utils.MailSenderService;
import mx.unam.backend.utils.StringUtils;

/**
 * <p>
 * Implementación de la interfaz {@link mx.unam.backend.service.UsuarioService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan
 * {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author garellano, mentesniker
 * @see unam.mx.backend.domain.Usuario
 * @see mx.unam.backend.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioMapper usuarioMapper;
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private RegistroMapper registroMapper;
    private final MailSenderService mailSenderService;
    @Value("${jwt.encryptor.password}")
    private String encryptKey;
    private static final int RANDOM_STRING_LEN = 6;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, MailSenderService mailSenderService,
            RegistroMapper registroMapper, UsuarioDetalleMapper usuarioDetalleMapper) {
        this.usuarioMapper = usuarioMapper;
        this.mailSenderService = mailSenderService;
        this.registroMapper = registroMapper;
        this.usuarioDetalleMapper = usuarioDetalleMapper;
    }

    /** {@inheritDoc} */
    @Override
    public Login login(CredencialesRequest usuario) throws ControllerException {

        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000 * 60 * 5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        // Usuario no existente
        if (usuario.getMail() == null)
            throw new CustomException(EnumMessage.BAD_CREDENTIALS);

        Usuario validUser = usuarioMapper.getByMail(usuario.getMail());

        if (validUser == null)
            throw new CustomException(EnumMessage.BAD_CREDENTIALS);

        if (!validUser.isActivo())
            throw new CustomException(EnumMessage.DISABLED_USER);

        // Usuario bloqueado
        long instanteDeBloqueo = validUser.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if (instanteDeBloqueo > 0 && restante > 0) {
            long totalSegundos = restante / 1000;
            long totalMinutos = totalSegundos / 60;
            throw new CustomException(EnumMessage.WAIT_LOGIN, totalMinutos, totalSegundos % 60);
        }

        // Clave incorrecta
        String passwordHasheado = DigestEncoder.digest(usuario.getClave(), usuario.getMail());
        if (!passwordHasheado.equals(validUser.getClave())) {
            int numeroDeIntentosFallidos = validUser.getAccesoNegadoContador() + 1;
            validUser.setAccesoNegadoContador(numeroDeIntentosFallidos);
            usuarioMapper.update(validUser);

            if (numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                validUser.setInstanteBloqueo(instanteActual);
                throw new CustomException(EnumMessage.MAX_FAILED_LOGIN_EXCEPTION, maximoNumeroIntentosConcedidos);
            }

            throw new CustomException(EnumMessage.BAD_CREDENTIALS, numeroDeIntentosFallidos,
                    maximoNumeroIntentosConcedidos);

        }

        // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y
        // retorna el usuario:
        validUser.setAccesoNegadoContador(0);
        validUser.setInstanteBloqueo(0);
        validUser.setInstanteUltimoAcceso(instanteActual);
        usuarioMapper.update(validUser);

        Login loginResponse = new Login();
        loginResponse.setMail(validUser.getMail());
        String jwt = JWTUtil.getInstance().createToken(usuario.getMail(), 27, this.encryptKey);
        loginResponse.setJwt(jwt);
        loginResponse.setRoles(usuarioMapper.getRoles(validUser.getMail()));
        loginResponse.setId(validUser.getId());
        return loginResponse;
    }

    /** {@inheritDoc} */
    @Override
    public Usuario solicitaRegeneracionClave(String correo) throws ServiceException {
        String token = StringUtils.getRandomString(6);
        Usuario usuario = usuarioMapper.getByMail(correo);
        if (usuario != null) {
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
        long unaHora = 1000 * 60 * 60L;
        Usuario usuario = usuarioMapper.getByToken(tokenRequest.getToken());
        if (usuario == null)
            throw new CustomException(EnumMessage.TOKEN_NOT_EXIST);
        if (!tokenRequest.getToken().equals(usuario.getRegeneraClaveToken()))
            throw new CustomException(EnumMessage.TOKEN_NOT_EXIST);
        long remaining = System.currentTimeMillis() - usuario.getRegeneraClaveInstante();
        if (remaining < unaHora) {
            String claveHash = DigestEncoder.digest(tokenRequest.getClaveNueva(), usuario.getMail());
            usuario.setClave(claveHash);
            usuario.setRegeneraClaveToken(tokenRequest.getToken());
            usuarioMapper.update(usuario);
            return usuario;
        } else {
            throw new CustomException(EnumMessage.TOKEN_EXPIRED);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Preregistro preRegistro(Preregistro preRegistroRequest) throws ServiceException {
        try {
            return preRegistroHelper(preRegistroRequest);
        } catch (SQLException e) {
            throw new ServiceException("Clave con error", "error al registrar al usuario", 2001, "intentelo de nuevo",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = TransactionException.class)
    public Usuario confirmaPreregistro(String token) throws ServiceException {
        // El token sirve sólo 10 minutes:
        long delta = 1000 * 60 * 10L;

        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = null;
        try {
            preregistro = this.registroMapper.getByRandomString(token);
        } catch (SQLException e1) {
            throw new ServiceException("Clave con error", "error al buscar un usuario con el token", 2000,
                    "intentelo de nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Si no hay un registro asociado a tal token, notifica el error:
        if (preregistro == null)
            throw new CustomException(EnumMessage.TOKEN_NOT_EXIST);

        // Si ya expiró el token, notifica el error:
        long age = System.currentTimeMillis() - preregistro.getInstanteRegistro();
        if (age > delta) { // token expirado
            throw new CustomException(EnumMessage.TOKEN_EXPIRED);
        }

        // Si todito lo anterior salió bien, actualiza los
        // datos, guárdalos y elimina el preregistro auxiliar:
        try {
            return doTransaction(preregistro, token);
        } catch (SQLException e) {
            throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
        }
    }

    private Usuario doTransaction(Preregistro preregistro, String randomString) throws SQLException {
        // Crea un usuario e insertalo en la base:
        Usuario usuario = new Usuario(
                0, // id (que va a ser autogenerado)
                preregistro.getCorreo(), // correo
                preregistro.getClaveHash(), // clave
                System.currentTimeMillis(), // creado
                true, // activo
                0, // accesoNegadoContador
                0, // instanteBloqueo
                0, // instanteUltimoAcceso
                System.currentTimeMillis(), // instanteUltimoCambioClave
                "", // regeneraClaveToken
                0 // regeneraClaveTokenInstante
        );
        usuarioMapper.insert(usuario);

        // Obtén el id autogenerado del usuario recién creado:
        int idUsuario = usuario.getId();

        // Crea un objeto 'usuarioDetalles' (con el ID autogenerado) e insértalo en la
        // DB:
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle(
                idUsuario,
                preregistro.getNombre(), // nombre
                preregistro.getPrimerApellido(), // apellidoPaterno
                preregistro.getSegundoApellido(), // apellidoMaterno
                preregistro.getNick(), // nickName
                preregistro.getFechaNacimiento(), // fechaNacimiento
                preregistro.getTelefono() // telefonoCelular
        );
        this.usuarioDetalleMapper.insert(usuarioDetalle);

        // asociar el usuario recién creado con el rol 2:
        this.usuarioMapper.insertUserRol(idUsuario, 2);

        // Borra lo que tengas en la tabla registro
        this.registroMapper.deleteByRandomString(randomString);

        return usuario;
    }

    private Preregistro preRegistroHelper(Preregistro preRegistroRequest) throws CustomException, SQLException {
        // Quitale los caracteres raros al teléfono.
        String nuevoCel = StringUtils.limpia(preRegistroRequest.getTelefono());
        preRegistroRequest.setTelefono(nuevoCel);

        // Valida si la clave proporcionada es compatible con el
        // patrón de seguridad de claves solicitado por el sistema:
        validate(preRegistroRequest.getClaveHash());

        // Busca al usuario por su correo en la tabla de 'usuario'
        Usuario usuario = this.usuarioMapper.getByMail(preRegistroRequest.getCorreo());

        // Si el usuario ya está en la tabla 'usuario', avisa error:
        if (usuario != null)
            throw new CustomException(EnumMessage.USER_ALREADY_EXISTS, "el usuario ya esta registrado");

        // Busca el registro por mail en la tabla de 'registro':
        Preregistro registro = this.registroMapper.getByMail(preRegistroRequest.getCorreo());

        // Genera una cadena aleatoria de caracteres y crea un objeto de tipo
        // 'PreRegistro':
        String randomString = StringUtils.getRandomString(RANDOM_STRING_LEN);

        // Calcula el Hash de la clave con un salt del correo:
        String claveHasheada = DigestEncoder.digest(preRegistroRequest.getClaveHash(), preRegistroRequest.getCorreo());

        // Asigna valores:
        preRegistroRequest.setRandomString(randomString);
        preRegistroRequest.setInstanteRegistro(System.currentTimeMillis());
        preRegistroRequest.setClaveHash(claveHasheada);

        // Si el usuario NO está en la tabla de 'registro', insertar info:
        if (registro == null) {
            this.registroMapper.insertRegistro(preRegistroRequest);
        } else { // Si el usuario SI está: actualizar info:
            this.registroMapper.update(preRegistroRequest);
        }

        // Envia correo de notificación:
        sendMail(
                preRegistroRequest.getNick(),
                preRegistroRequest.getCorreo(),
                randomString,
                "Clave de confirmación de registro");
        return preRegistroRequest;
    }

    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body = String.format(
                "<h1>Hola %s. Tu clave de acceso es %s y tiene una validez de %d minutos. (body auxiliar) </h1>", nick,
                randomString, 10);
        this.mailSenderService.sendHtmlMail(correo, titulo, body);
    }

    private void validate(String clave) throws CustomException {
        // 8 and 16 characters
        if (clave.length() < 8 || clave.length() > 16) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR,
                    "Introducir una clave de 8 hasta 16 caracteres.");
        }
        // Rule 2: No whitespace allowed
        if (clave.contains(" ")) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Remover espacios en blanco.");
        }
        // Rule 3: At least one Upper-case character
        if (!clave.matches("^(?=.*[A-Z]).+$")) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar una mayuscula a la clave.");
        }
        // Rule 4: At least one Lower-case character
        if (!clave.matches("^(?=.*[a-z]).+$")) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar una minuscula a la clave.");
        }
        // Rule 5: At least one digit
        if (!clave.matches("^(?=.*\\d).+$")) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR, "Agregar un numero a la clave.");
        }
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(clave);
        // Rule 5: At least one special character
        if (!hasSpecial.find()) {
            throw new CustomException(EnumMessage.STRENGTH_PASSWORD_VALIDATOR,
                    "Agregar un caracter especial a la clave.");
        }
    }

    @Override
    public UsuarioDetalle solicitarUsuario(int usuarioId) throws ServiceException {
        return usuarioDetalleMapper.getByUsuarioId(usuarioId);
    }

}