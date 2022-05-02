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
import mx.unam.backend.model.Publicacion;


/**
 * <p>Definición de la interfaz de servicios para 'Login'.
 *
 * @author  Gerardo García
 * @see     mx.unam.backend.model.Publicacion
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface PublicacionService {

    // Publicacion getPublicacion(int id);
    // List<Publicacion> getPublicaciones(int usuarioId);
    // int inserta(Publicacion p) throws ServiceException;
    int actualiza(Publicacion p) throws ServiceException;
    int borra(int p) throws ServiceException;

    }