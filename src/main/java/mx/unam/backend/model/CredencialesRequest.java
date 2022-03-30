/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      CredencialesRequest
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.model;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'usuario'.
 *
 * @author mentesniker
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CredencialesRequest {

    private String mail;
    private String password;

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param mail un objeto de tipo {@link java.lang.String}.
     * @param password un objeto de tipo {@link java.lang.String}.
     */
    public CredencialesRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    /**
     * Constructor por default (sin parámetros).
     */
    public CredencialesRequest() {
    }

    /**
     * <p>Getter para el atributo <code>mail</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * <p>Setter para el atributo <code>mail</code>.</p>
     *
     * @param mail un objeto de tipo {@link java.lang.String}.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * <p>Getter para el atributo <code>clave</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getClave() {
        return this.password;
    }

    /**
     * <p>Setter para el atributo <code>clave</code>.</p>
     *
     * @param password un objeto de tipo {@link java.lang.String}.
     */
    public void setClave(String password) {
        this.password = password;
    }

}
