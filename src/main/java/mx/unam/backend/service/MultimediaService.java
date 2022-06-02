/*
*
* Paquete:     unam.mx.backend.model
* Proyecto:    licenciatura-backend
* Tipo:        interface
* Nombre:      MultimediaService
* Autor:       Noyola Nazario Alejandro
* Versión:     1.0-SNAPSHOT
*
* Historia:
*              Creación: 02 Mar 2022
*/
package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Multimedia;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author Gerardo García
 * @see mx.unam.backend.model.Publicacion
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface MultimediaService {

    Integer creaMultimedia(Multimedia in) throws SQLException;

    Multimedia solicitarImagen(int imagenId) throws ServiceException;

    Multimedia solicitarVideo(int videoId) throws ServiceException;

    List<Multimedia> solicitaMultimedias(int publicacion_id) throws ServiceException;

    void borraMultimedia(int cmtId);

    int actualizaMultimedia(Multimedia in);
}
