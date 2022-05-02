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

    /**
     * <p>Getter para el campo <code>imagenId</code>.</p>
     *
     * @return un String.
     */
    public String getImagenId() {
        return this.imagenId;
    }

    /**
     * <p>Setter para el campo <code>imagenId</code>.</p>
     * 
     * @param imagenId
     */
    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
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
     * <p>Getter para el campo <code>imagen</code>.</p>
     *
     * @return un String.
     */
    public String getImagen() {
        return this.imagen;
    }

    /**
     * <p>Setter para el campo <code>imagen</code>.</p>
     * 
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Constructor de la clase Imagen.
     * @param imagenId Identificador de la imagen en la base de datos.
     * @param publicacionId identificador de la publicación a la que pertenece la imagen.
     * @param imagen url en el que se encuentra la imagen en el servidor.
     */
    public Imagen(String imagenId, String publicacionId, String imagen){
        this.imagenId = imagenId;
        this.publicacionId = publicacionId;
        this.imagen = imagen;
    }
}
