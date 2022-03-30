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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long getCreado() {
        return this.creado;
    }

    public void setCreado(long creado) {
        this.creado = creado;
    }

}
