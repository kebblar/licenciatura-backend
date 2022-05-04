/*
*
* Paquete:     unam.mx.backend.model
* Proyecto:    licenciatura-backend
* Tipo:        interface
* Nombre:      GifService
* Autor:       Noyola Nazario Alejandro
* Versión:     1.0-SNAPSHOT
*
* Historia:
*              Creación: 02 Mar 2022
*/
package mx.unam.backend.service;

import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Gif;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author Gerardo García
 * @see mx.unam.backend.model.Publicacion
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GifService {

    Gif solicitarGif(String comentId) throws ServiceException;

    Integer actualizaGif(Gif cmt);

    List<Gif> solicitaGifs(String publicacion_id) throws ServiceException;

    void borraGif(String cmtId);
}
