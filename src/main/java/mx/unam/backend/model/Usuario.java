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

/**
 * Implementacion del POJO de la entidad de 'Usuario'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Usuario {

    /*
     * Atributos de la clase.
     */
    private int id;
    private String mail;
    private String clave;
    private long creado;
    private boolean activo;
    private int accesoNegadoContador;
    private long instanteBloqueo;
    private long instanteUltimoAcceso;
    private long instanteUltimoCambioClave;
    private String regeneraClaveToken;
    private long regeneraClaveInstante;

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param id a int.
     * @param correo a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     * @param creado a long.
     * @param activo a boolean.
     * @param accesoNegadoContador a int.
     * @param instanteBloqueo a long.
     * @param instanteUltimoAcceso a long.
     */

    public Usuario(int id, String mail, String clave, long creado, 
    boolean activo, int accesoNegadoContador, long instanteBloqueo, 
    long instanteUltimoAcceso, long instanteUltimoCambioClave, 
    String regeneraClaveToken, long regeneraClaveInstante) {
        this.id = id;
        this.mail = mail;
        this.clave = clave;
        this.creado = creado;
        this.activo = activo;
        this.accesoNegadoContador = accesoNegadoContador;
        this.instanteBloqueo = instanteBloqueo;
        this.instanteUltimoAcceso = instanteUltimoAcceso;
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
        this.regeneraClaveToken = regeneraClaveToken;
        this.regeneraClaveInstante = regeneraClaveInstante;
    }


    public long getInstanteUltimoCambioClave() {
        return this.instanteUltimoCambioClave;
    }

    public void setInstanteUltimoCambioClave(long instanteUltimoCambioClave) {
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
    }

    public String getRegeneraClaveToken() {
        return this.regeneraClaveToken;
    }

    public void setRegeneraClaveToken(String regeneraClaveToken) {
        this.regeneraClaveToken = regeneraClaveToken;
    }

    public long getRegeneraClaveInstante() {
        return this.regeneraClaveInstante;
    }

    public void setRegeneraClaveInstante(long regeneraClaveInstante) {
        this.regeneraClaveInstante = regeneraClaveInstante;
    }


    /**
     * <p>Getter for the field <code>mail</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * <p>Setter for the field <code>mail</code>.</p>
     *
     * @param mail a {@link java.lang.String} object.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * <p>Getter for the field <code>clave</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * <p>Setter for the field <code>clave</code>.</p>
     *
     * @param clave a {@link java.lang.String} object.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return this.id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>creado</code>.</p>
     *
     * @return a long.
     */
    public long getCreado() {
        return this.creado;
    }

    /**
     * <p>Setter for the field <code>creado</code>.</p>
     *
     * @param creado a long.
     */
    public void setCreado(long creado) {
        this.creado = creado;
    }

    /**
     * <p>isActivo.</p>
     *
     * @return a boolean.
     */
    public boolean isActivo() {
        return this.activo;
    }

    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a boolean.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * <p>Getter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @return a int.
     */
    public int getAccesoNegadoContador() {
        return this.accesoNegadoContador;
    }

    /**
     * <p>Setter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @param accesoNegadoContador a int.
     */
    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }

    /**
     * <p>Getter for the field <code>instanteBloqueo</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteBloqueo() {
        return this.instanteBloqueo;
    }

    /**
     * <p>Setter for the field <code>instanteBloqueo</code>.</p>
     *
     * @param instanteBloqueo a long.
     */
    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }

    /**
     * <p>Getter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteUltimoAcceso() {
        return this.instanteUltimoAcceso;
    }

     /**
     * <p>Setter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @param instanteUltimoAcceso a long.
     */
    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }

}
