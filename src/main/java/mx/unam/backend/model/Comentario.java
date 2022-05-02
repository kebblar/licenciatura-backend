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

    /**
     * <p>Getter para el campo <code>comentarioId</code>.</p>
     *
     * @return un String.
     */
    public String getComentarioId() {
        return this.comentarioId;
    }

    /**
     * <p>Setter para el campo <code>comentarioId</code>.</p>
     * 
     * @param comentarioId
     */
    public void setComentarioId(String comentarioId) {
        this.comentarioId = comentarioId;
    }

    /**
     * <p>Getter para el campo <code>publicacionId</code>.</p>
     *
     * @return un String.
     */
    public String getPublicacionId() {
        return this.publicacionId;
    }

    /**
     * <p>Setter para el campo <code>publicacionId</code>.</p>
     * 
     * @param publicacionId
     */
    public void setPublicacionId(String publicacionId) {
        this.publicacionId = publicacionId;
    }

    /**
     * <p>Getter para el campo <code>usuarioCreadorId</code>.</p>
     *
     * @return un String.
     */
    public String getUsuarioCreadorId() {
        return this.usuarioCreadorId;
    }

    /**
     * <p>Setter para el campo <code>usuarioCreadorId</code>.</p>
     * 
     * @param usuarioCreadorId
     */
    public void setUsuarioCreadorId(String usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    /**
     * <p>Getter para el campo <code>comentario</code>.</p>
     *
     * @return un String.
     */
    public String getComentario() {
        return this.comentario;
    }

    /**
     * <p>Setter para el campo <code>comentario</code>.</p>
     * 
     * @param comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * <p>Getter para el campo <code>fechaCreacion</code>.</p>
     *
     * @return un Date.
     */
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * <p>Setter para el campo <code>fechaCreacion</code>.</p>
     * 
     * @param fechaCreacion
     */
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
