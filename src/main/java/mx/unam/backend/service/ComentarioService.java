/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        interface
 * Nombre:      ImagenService
 * Autor:       Noyola Alejandro
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 01 May 2022
 */
package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Comentario;

public interface ComentarioService {

    /**
     * Solicita la generacion de un comentario.
     * el metodo regresa una instancia de {@link Comentario} que
     * tiene todos sus valores por defecto.
     *
     * @param in String asociado al comentario asociado
     * @return objeto de la clase {@link Comentario}
     * @throws ServiceException if any
     * @throws SQLException
     */
    Integer inserta(Comentario in) throws ServiceException, SQLException;

    Comentario solicitarComentario(int comentId) throws ServiceException;

    Integer actualizaComentario(Comentario cmt);

    List<Comentario> solicitaComentarios(int publicacion_id) throws ServiceException;

    void borraComentario(int cmtId);

}
