/*
 *
 * Paquete:     mx.unam.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        interface
 * Nombre:      AuthenticatorService
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 21 Mar 2022
 */
package mx.unam.backend.utils;

import mx.unam.backend.exceptions.ServiceException;

/**
 * <p>Definición de la interfaz de servicios para Authenticacion.
 *
 * @author  mentesniker
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface AuthenticatorService {

    /**
     * Revisa si el correo contenido en el jwt recibido
     * tiene el rol especificado por el primer parametro.
     *
     * @param rolObjetivo String con el rol que deberia de tener 
     * el usuario para acceder al recurso.
     * @param jwt String con el token del usuario.
     * @throws ServiceException if any
     */
    public void authentica(String rolObjetivo, String jwt) throws ServiceException;
}
