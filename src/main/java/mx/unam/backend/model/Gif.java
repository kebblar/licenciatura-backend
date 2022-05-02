/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Gif
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 19 Abr 2022
 */
package mx.unam.backend.model;

/**
 * Implementacion del POJO de la entidad de 'Gif'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Gif {
    private String gifId;
    private String publicacionId;
    private String gif;

    /**
     * <p>Getter para el campo <code>gifId</code>.</p>
     *
     * @return un String.
     */
    public String getGifId() {
        return this.gifId;
    }

    /**
     * <p>Setter para el campo <code>gifId</code>.</p>
     * 
     * @param gifId
     */
    public void setGifId(String gifId) {
        this.gifId = gifId;
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
     * <p>Getter para el campo <code>gif</code>.</p>
     *
     * @return un String.
     */
    public String getGif() {
        return this.gif;
    }

    /**
     * <p>Setter para el campo <code>gif</code>.</p>
     * 
     * @param gif
     */
    public void setGif(String gif) {
        this.gif = gif;
    }

    /**
     * Constructor de la clase Gif
     * @param gifId identificador del gif.
     * @param publicacionId identificador de la publicación a la que pertenece el gif.
     * @param gif ruta donde se encuentra el gif.
     */
    public Gif(String gifId, String publicacionId, String gif){
        this.gifId=gifId;
        this.publicacionId=publicacionId;
        this.gif = gif;
    }
}
