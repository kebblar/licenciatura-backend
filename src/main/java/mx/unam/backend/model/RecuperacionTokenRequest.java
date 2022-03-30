/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      RecuperacionTokenRequest
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 11 Mar 2022
 */
package mx.unam.backend.model;

/**
 * Implementacion del POJO de la entidad de 'RecuperacionTokenRequest'.
 *
 * @author  mentesniker
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class RecuperacionTokenRequest {

    /*
     * Atributos de la clase.
     */
    private String token;
    private String claveNueva;

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param token a {@link java.lang.String} object.
     * @param claveNueva a {@link java.lang.String} object.
     * @param mail a {@link java.lang.String} object.
     */
    public RecuperacionTokenRequest(String token, String claveNueva) {
        this.token = token;
        this.claveNueva = claveNueva;
    }


    /**
     * <p>Getter for the field <code>token</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getToken() {
        return this.token;
    }

    /**
     * <p>Setter for the field <code>token</code>.</p>
     *
     * @param token a {@link java.lang.String} object.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * <p>Getter for the field <code>claveNueva</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClaveNueva() {
        return this.claveNueva;
    }

    /**
     * <p>Setter for the field <code>claveNueva</code>.</p>
     *
     * @param claveNueva a {@link java.lang.String} object.
     */
    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

}
