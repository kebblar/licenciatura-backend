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
package unam.mx.backend.service;

import unam.mx.backend.exceptions.ControllerException;
import unam.mx.backend.model.CredencialesRequest;
import unam.mx.backend.model.Login;


/**
 * <p>Definición de la interfaz de servicios para 'Login'.
 *
 * @author  mentesniker, garellano
 * @see     unam.mx.backend.model.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface LoginService {

    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto Login cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el usuario no existe, sólo pide que intente de nuevo
     *     - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param usuario cadena que contiene el usuario
     * @param clave  cadena que contiene la contraseña
     * @return Objeto {@link Login}
     * @throws ControllerException
     */
    public Login login(CredencialesRequest usuario) throws ControllerException;
}