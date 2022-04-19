/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Comentario
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 19 Abr 2022
 */
package mx.unam.backend.model;

import java.util.Date;

/**
 * Implementacion del POJO de la entidad de 'Comentario'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Comentario {
    private String comentarioId;
    private String publicacionId;
    private String usuarioCreadorId;
    private String comentario;
    private Date fechaCreacion;

    public String getComentarioId() {
        return this.comentarioId;
    }

    public void setComentarioId(String comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getPublicacionId() {
        return this.publicacionId;
    }

    public void setPublicacionId(String publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getUsuarioCreadorId() {
        return this.usuarioCreadorId;
    }

    public void setUsuarioCreadorId(String usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Constructor de la clase comentario.
     * @param comentarioId es un String. Es el identificador del comentario en la base de datos.
     * @param publicacionId es un String. Es el identificador de la publicación a la que pertenece elcomentario.
     * @param usuarioCreadorId es un String. Es una referencia al identificador del usuario que creó la publicación.
     * @param comentario es el contenido del comentario.
     * @param fechaCreacion es la fecha de creación del comentario. Es de tipo date.
     */
    public Comentario(String comentarioId, String publicacionId, String usuarioCreadorId, String comentario, Date fechaCreacion){
        this.comentarioId = comentarioId;
        this.publicacionId = publicacionId;
        this.usuarioCreadorId = usuarioCreadorId;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
    }

    
}
