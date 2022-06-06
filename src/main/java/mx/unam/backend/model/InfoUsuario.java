package mx.unam.backend.model;

public class InfoUsuario {
    private int id;
    private String mail;
    private String clave;
    private long creado;


    public InfoUsuario(int id, String mail, String clave, long creado) {
        this.id = id;
        this.mail = mail;
        this.clave = clave;
        this.creado = creado;
    }

    /**
     * <p>Getter para el atributo <code>Id</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public int getId() {
        return this.id;
    }

    /**
     * <p>Setter para el atributo <code>Id</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  <p>Getter para el atributo <code>mail</code>mail</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * <p>Setter para el atributo <code>mail</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
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
        return this.clave;
    }

    /**
     * <p>Setter para el atributo <code>clave</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * <p>Getter para el atributo <code>creado</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public long getCreado() {
        return this.creado;
    }

    /**
     * <p>Setter para el atributo <code>creado</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setCreado(long creado) {
        this.creado = creado;
    }

}
