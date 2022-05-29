/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Login
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.model;

import java.util.List;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'Login'.
 *
 * @author mentesniker
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Login {
    private int id;
    private String mail;
    private String jwt;
    private List<Rol> roles;

    /**
     * Constructor por default (sin parámetros).
     */
    public Login() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param mail un objeto de tipo {@link java.lang.String}.
     * @param jwt un objeto de tipo {@link java.lang.String}.
     * @param roles una lista de objetos de tipo {@link mx.unam.backend.model.Rol}.
     */
    public Login(String mail, String jwt, List<Rol> roles) {
        this.mail = mail;
        this.jwt = jwt;
        this.roles = roles;
    }

    /**
     * <p>Getter para el atributo <code>roles</code>.</p>
     *
     * @return una lista de objetos de tipo {@link mx.unam.backend.model.Rol}.
     */
    public List<Rol> getRoles() {
        return this.roles;
    }

    /**
     * <p>Setter para el atributo <code>roles</code>.</p>
     *
     * @param una lista de objetos de tipo {@link mx.unam.backend.model.Rol}.
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /**
     * <p>Getter para el atributo <code>roles</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * <p>Setter para el atributo <code>roles</code>.</p>
     *
     * @param mail un objeto de tipo {@link java.lang.String}.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * <p>Getter para el atributo <code>roles</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getJwt() {
        return this.jwt;
    }

    /**
     * <p>Setter para el atributo <code>roles</code>.</p>
     *
     * @param jwt un objeto de tipo {@link java.lang.String}.
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /**
     * <p>Setter para el atributo <code>id</code>.</p>
     *
     * @param id un int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter para el atributo <code>id</code>.</p>
     *
     * @return un int.
     */
    public int getId() {
        return this.id;
    }

}
