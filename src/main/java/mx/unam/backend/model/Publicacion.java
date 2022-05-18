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

/**
 * Implementacion del POJO de la entidad de 'Publicacion'.
 *
 * @author Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Publicacion {

    private int publicacionId;
    private int usuarioId;
    private String textoPublicacion;
    private String fechaCreacion;
    private boolean esPublica;

    /**
     * Constructor de la clase Publicacion.
     * 
     * @param publicacionId    identificador de la publicación.
     * @param usuarioId        usuario que creó la publicación
     * @param textoPublicacion texto que se escribió dentro de la publicación.
     * @param nMeGusta         número de me gustas que tiene la publicación.
     */
    public Publicacion(int publicacionId, int usuarioId, String fechaCreacion, String textoPublicacion,
            boolean esPublica) {
        this.publicacionId = publicacionId;
        this.usuarioId = usuarioId;
        this.textoPublicacion = textoPublicacion;
        this.fechaCreacion = fechaCreacion;
        this.esPublica = esPublica;
    }

    /**
     * <p>
     * Getter para el campo <code>publicacionId</code>.
     * </p>
     *
     * @return un int.
     */
    public int getId() {
        return this.publicacionId;
    }

    /**
     * <p>
     * Setter para el campo <code>publicacionId</code>.
     * </p>
     * 
     * @param publicacionId
     */
    public void setId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    /**
     * <p>
     * Getter para el campo <code>textoPublicacion</code>.
     * </p>
     *
     * @return un String.
     */
    public String getTextoPlano() {
        return this.textoPublicacion;
    }

    /**
     * <p>
     * Setter para el campo <code>textoPublicacion</code>.
     * </p>
     * 
     * @param textoPublicacion
     */
    public void setTextoPlano(String textoPublicacion) {
        this.textoPublicacion = textoPublicacion;
    }

    /**
     * <p>
     * Getter para el campo <code>fechaCreacion</code>.
     * </p>
     *
     * @return un Date.
     */
    public String getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * <p>
     * Setter para el campo <code>fechaCreacion</code>.
     * </p>
     * 
     * @param fechaCreacion
     */
    public void setTitulo(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * <p>
     * Getter para el campo <code>usuarioId</code>.
     * </p>
     *
     * @return un String.
     */
    public int getUsuarioId() {
        return this.usuarioId;
    }

    /**
     * <p>
     * Setter para el campo <code>usuarioId</code>.
     * </p>
     * 
     * @param usuarioId
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * <p>
     * Getter para el campo <code>esPublica</code>.
     * </p>
     *
     * @return un booleano.
     */
    public boolean getEsPublica() {
        return this.esPublica;
    }

    /**
     * <p>
     * Setter para el campo <code>esPublica</code>.
     * </p>
     * 
     * @param esPublica
     */
    public void setComentarios(boolean esPublica) {
        this.esPublica = esPublica;
    }
}
