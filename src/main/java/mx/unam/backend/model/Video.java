/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Video
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 19 Abr 2022
 */
package mx.unam.backend.model;

/**
 * Implementacion del POJO de la entidad de 'Video'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Video {
    private String videoId;
    private String publicacionId;
    private String video;

    /**
     * <p>Getter para el campo <code>videoId</code>.</p>
     *
     * @return un String.
     */
    public String getVideoId() {
        return this.videoId;
    }

    /**
     * <p>Setter para el campo <code>videoId</code>.</p>
     * 
     * @param videoId
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
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
     * <p>Getter para el campo <code>video</code>.</p>
     *
     * @return un String.
     */
    public String getVideo() {
        return this.video;
    }

    /**
     * <p>Setter para el campo <code>video</code>.</p>
     * 
     * @param video
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * Constructor de la clase Video.
     * @param videoId Identificador del video en la base de datos.
     * @param publicacionId identificador de la publicación a la que pertenece el video.
     * @param video url en el que se encuentra el video en el servidor.
     */
    public Video(String videoId, String publicacionId, String video){
        this.videoId = videoId;
        this.publicacionId = publicacionId;
        this.video = video;
    }
}
