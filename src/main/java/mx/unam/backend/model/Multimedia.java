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
    private int usuarioCreadorId;
    private String multimedia;
    private boolean esVideo;

    /**	
     * Crea objetos multimedia con los parametros (int multimdeiaId, Int publicacionId, etc)
     *, ,,, 
     * @param int multimediaId
     * @param int publicacionId
     * @param int usuarioCreadorId
     * @param String multimedia
     * @param boolean esVideo
     
     */	
    public Multimedia(int multimediaId, int publicacionId, int usuarioCreadorId, String multimedia, boolean esVideo) {
        this.multimediaId = multimediaId;
        this.publicacionId = publicacionId;
        this.usuarioCreadorId = usuarioCreadorId;
        this.multimedia = multimedia;
        this.esVideo = esVideo;
    }

    /**
     * <p>Getter para el atributo <code>multimediaId</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public int getMultimediaId() {
        return this.multimediaId;
    }

    /**
     * <p>Setter para el atributo <code>multimediaId</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setMultimediaId(int multimediaId) {
        this.multimediaId = multimediaId;
    }

    /**
     * <p>Getter para el atributo <code>publicacionId</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public int getPublicacionId() {
        return this.publicacionId;
    }

    /**
     * <p>Setter para el atributo <code>publicacionId</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    /**
     * <p>Getter para el atributo <code>usuarioCreador</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public int getUsuarioCreador() {
        return this.usuarioCreadorId;
    }

    /**
     * <p>Setter para el atributo <code>usuarioCreador</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setUsuarioCreador(int usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    /**
     * <p>Getter para el atributo <code>multimedia</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getMultimedia() {
        return this.multimedia;
    }

    /**
     * <p>Setter para el atributo <code>multimedia</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public boolean isEsVideo() {
        return this.esVideo;
    }

    /**
     * <p>Getter para el atributo <code>esVideo</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public boolean getEsVideo() {
        return this.esVideo;
    }

    /**
     * <p>Getter para el atributo <code>multimedia</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setEsVideo(boolean esVideo) {
        this.esVideo = esVideo;
    }

}
