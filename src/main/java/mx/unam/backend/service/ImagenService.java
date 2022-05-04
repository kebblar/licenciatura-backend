/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        interface
 * Nombre:      ImagenService
 * Autor:       Nooyola Alejandro
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 01 May 2022
 */
package mx.unam.backend.service;

import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Imagen;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author Gerardo García
 * @see mx.unam.backend.model.Imagen
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface ImagenService {

    Imagen solicitarImagen(String comentId) throws ServiceException;

    Integer actualizaImagen(Imagen cmt);

    List<Imagen> solicitaImagenes(String publicacion_id) throws ServiceException;

    void borraImagen(String cmtId);
}
