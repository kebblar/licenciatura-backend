/*
*
* Paquete:     unam.mx.backend.model
* Proyecto:    licenciatura-backend
* Tipo:        interface
* Nombre:      VideoService
* Autor:       Noyola Nazario Alejandro
* Versión:     1.0-SNAPSHOT
*
* Historia:
*              Creación: 02 Mar 2022
*/
package mx.unam.backend.service;

import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Video;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author Gerardo García
 * @see mx.unam.backend.model.Publicacion
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface VideoService {

    Video solicitarVideo(String comentId) throws ServiceException;

    Integer actualizaVideo(Video cmt);

    List<Video> solicitaVideos(String publicacion_id) throws ServiceException;

    void borraVideo(String cmtId);
}
