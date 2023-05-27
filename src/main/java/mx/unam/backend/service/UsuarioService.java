/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        interface
 * Nombre:      LoginService
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.service;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Login;
import mx.unam.backend.model.Preregistro;
import mx.unam.backend.model.RecuperacionTokenRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.model.UsuarioDetalle;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author mentesniker, garellano
 * @see mx.unam.backend.model.Usuario
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface UsuarioService {

    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto Login cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     * - No admite usuario ni clave vacios
     * - Si el usuario no existe, sólo pide que intente de nuevo
     * - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos
     * intentos
     * - Si el usuario está bloqueado (con o sin clave correcta) le indicará que
     * debe esperar cierto tiempo
     * 
     * @param usuario objeto de tipo {@link CredencialesRequest}
     * @return Objeto {@link Login}
     * @throws ControllerException
     */
    public Login login(CredencialesRequest usuario) throws ControllerException;

    /**
     * Solicita la regeneración de una clave perdida u olvidada.
     * En caso de no encontrar el correo solicitado
     * el metodo regresa una instancia de {@link Usuario} que
     * tiene todos sus valores por defecto.
     *
     * @param correo String asociado a la clave olvidada
     * @return objeto de la clase {@link Usuario}
     * @throws ServiceException if any
     */
    Usuario solicitaRegeneracionClave(String correo) throws ServiceException;

    /**
     * Solicita un usario
     * el metodo regresa una instancia de {@link Usuariodetalle}
     *
     * @param usuarioId La id del usuario solicitado
     * @return objeto de la clase {@link UsuarioDetalle}
     * @throws ServiceException if any
     */
    UsuarioDetalle solicitarUsuario(int usuarioId) throws ServiceException;

    /**
     * Confirma la regeneración de una nueva clave a un usuario.
     * El metodo realiza una verificacion de la nueva clave que tiene que
     * cumplir con las siguientes reglas:
     * - No admite clave con espacios
     * - No admite claves con solo minusculas
     * - No admite claves con solo mayusuculas
     * - No admite claves sin caracteres especiales
     * - No admite claves con menos de 8 y mas de 16 caracteres
     * 
     * @param tokenRequest objeto de la clase {@link RecuperacionTokenRequest}
     *
     * @return Usuario con clave actualizada
     * @throws ServiceException if any
     */
    Usuario confirmaRegeneraClave(RecuperacionTokenRequest tokenRequest) throws ServiceException;

    /**
     * Realiza el preregistro de un potencial usuario al sistema
     *
     * @param preRegistroRequest
     * @return Preregistro mismo objeto recibido
     * @throws BusinessException
     */
    Preregistro preRegistro(Preregistro preRegistroRequest) throws ServiceException;

    /**
     * Confirma el registro de un usuario al sistema
     *
     * @param token Cadena con la clave de confirmación del registro
     * @return entero con el id del usuario recién confirmado (debe ser mayor a
     *         cero)
     * @throws BusinessException
     */
    Usuario confirmaPreregistro(String token) throws ServiceException;
}