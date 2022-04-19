/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Imagen
 * Autor:       Miguel Liera
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 19 Abr 2022
 */
package mx.unam.backend.model;

/**
 * Implementacion del POJO de la entidad de 'Imagen'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Imagen {
    private String imagenId;
    private String publicacionId;
    private String imagen;

    public String getImagenId() {
        return this.imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }

    public String getPublicacionId() {
        return this.publicacionId;
    }

    public void setPublicacionId(String publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Constructor de la clase Imagen.
     * @param imagenId Identificador de la imagen en la base de datos.
     * @param publicacionId identificador de la publicación a la que pertenece la imagen.
     * @param imagen imagen códificada.
     */
    public Imagen(String imagenId, String publicacionId, String imagen){
        this.imagenId = imagenId;
        this.publicacionId = publicacionId;
        this.imagen = imagen;
    }
}
