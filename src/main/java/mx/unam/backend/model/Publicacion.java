/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Publicacion
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 14 Abr 2022
 */
package mx.unam.backend.model;

import java.util.Date;

/**
 * Implementacion del POJO de la entidad de 'Publicacion'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Publicacion {

    private String publicacionId;
    private String propietarioId;
    private String textoPublicacion;
    private Date fechaCreacion;
    private boolean esPublica;

    /**
     * Constructor de la clase Publicacion.
     * @param publicacionId identificador de la publicación.
     * @param propietarioId usuario que creó la publicación
     * @param textoPublicacion texto que se escribió dentro de la publicación.
     * @param nMeGusta número de me gustas que tiene la publicación.
     */
    public Publicacion(String publicacionId, String propietarioId, Date fechaCreacion, String textoPublicacion, boolean esPublica){
        this.publicacionId=publicacionId;
        this.propietarioId = propietarioId;
        this.textoPublicacion = textoPublicacion;
        this.fechaCreacion = fechaCreacion;
        this.esPublica = esPublica;
    }

    /**
     * <p>Getter para el campo <code>publicacionId</code>.</p>
     *
     * @return un int.
     */
    public String getId() {
        return this.publicacionId;
    }

    public void setId(String publicacionId) {
        this.publicacionId = publicacionId;
    }

    /**
     * <p>Getter para el campo <code>textoPublicacion</code>.</p>
     *
     * @return un String.
     */
    public String getTextoPlano() {
        return this.textoPublicacion;
    }

    public void setTextoPlano(String textoPublicacion) {
        this.textoPublicacion = textoPublicacion;
    }

    /**
     * <p>Getter para el campo <code>fechaCreacion</code>.</p>
     *
     * @return un Date.
     */
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setTitulo(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * <p>Getter para el campo <code>propietarioId</code>.</p>
     *
     * @return un String.
     */
    public String getPropietarioId() {
        return this.propietarioId;
    }

    public void setPropietarioId(String propietarioId) {
        this.propietarioId = propietarioId;
    }

    /**
     * <p>Getter para el campo <code>esPublica</code>.</p>
     *
     * @return un booleano.
     */
    public boolean getEsPublica() {
        return this.esPublica;
    }

    public void setComentarios(boolean esPublica) {
        this.esPublica = esPublica;
    }
}
