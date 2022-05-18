/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Multimedia
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 19 Abr 2022
 */
package mx.unam.backend.model;

/**
 * Implementacion del POJO de la entidad de 'Multimedia'.
 *
 * @author Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Multimedia {
    private int multimediaId;
    private int publicacionId;
    private String multimedia;
    private boolean esVideo;

    public Multimedia(int multimediaId, int publicacionId, String multimedia, boolean esVideo) {
        this.multimediaId = multimediaId;
        this.publicacionId = publicacionId;
        this.multimedia = multimedia;
        this.esVideo = esVideo;
    }

    public int getMultimediaId() {
        return this.multimediaId;
    }

    public void setMultimediaId(int multimediaId) {
        this.multimediaId = multimediaId;
    }

    public int getPublicacionId() {
        return this.publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getMultimedia() {
        return this.multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public boolean isEsVideo() {
        return this.esVideo;
    }

    public boolean getEsVideo() {
        return this.esVideo;
    }

    public void setEsVideo(boolean esVideo) {
        this.esVideo = esVideo;
    }

}
