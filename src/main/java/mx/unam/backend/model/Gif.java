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

    public String getGifId() {
        return this.gifId;
    }

    public void setGifId(String gifId) {
        this.gifId = gifId;
    }

    public String getPublicacionId() {
        return this.publicacionId;
    }

    public void setPublicacionId(String publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getGif() {
        return this.gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    /**
     * Constructor de la clase Gif
     * @param gifId identificador del gif.
     * @param publicacionId identificador de la publicación a la que pertenece el gif.
     * @param gif ruta donde se encuentra el gof.
     */
    public Gif(String gifId, String publicacionId, String gif){
        this.gifId=gifId;
        this.publicacionId=publicacionId;
        this.gif = gif;
    }
}
