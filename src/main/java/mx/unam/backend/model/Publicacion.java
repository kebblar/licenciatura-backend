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

import java.util.List;

/**
 * Implementacion del POJO de la entidad de 'Publicacion'.
 *
 * @author  Miguel Liera
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Publicacion {

    private int id;
    private String textoPlano;
    private String titulo;
    private Usuario propietario;
    private List<String> comentarios;
    private long nMeGusta;

    /**
     * Constructor de la clase Publicacion.
     * @param id identificador de la publicación.
     * @param titulo de la publicación
     * @param propietario usuario que creó la publicación
     * @param textoPlano texto que se escribió dentro de la publicación.
     * @param comentarios comentarios de la publicación
     * @param nMeGusta número de me gustas que tiene la publicación.
     */
    public Publicacion(int id, String titulo, Usuario propietario, String textoPlano, List<String> comentarios, long nMeGusta){
        this.id=id;
        this.titulo = titulo;
        this.propietario = propietario;
        this.textoPlano = textoPlano;
        this.comentarios = comentarios;
        this.nMeGusta = nMeGusta;
    }

    /**
     * <p>Getter para el campo <code>id</code>.</p>
     *
     * @return un int.
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter para el campo <code>textoPlano</code>.</p>
     *
     * @return un String.
     */
    public String getTextoPlano() {
        return this.textoPlano;
    }

    public void setTextoPlano(String textoPlano) {
        this.textoPlano = textoPlano;
    }

    /**
     * <p>Getter para el campo <code>titulo</code>.</p>
     *
     * @return un String.
     */
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * <p>Getter para el campo <code>propietario</code>.</p>
     *
     * @return un Usuario.
     */
    public Usuario getPropietario() {
        return this.propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    /**
     * <p>Getter para el campo <code>comentarios</code>.</p>
     *
     * @return una List.
     */
    public List<String> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * <p>Getter para el campo <code>nMeGusta</code>.</p>
     *
     * @return un long.
     */
    public long getNMeGusta() {
        return this.nMeGusta;
    }

    public void setNMeGusta(long nMeGusta) {
        this.nMeGusta = nMeGusta;
    }
}
