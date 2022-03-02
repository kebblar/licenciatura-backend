package unam.mx.backend.model;

public class Usuario {
    private int id;
    private String mail;
    private String clave;
    private long creado;
    private boolean activo;
    private int accesoNegadoContador;
    private long instanteBloqueo;
    private long instanteUltimoAcceso;


    public Usuario(int id,String mail, String clave, long creado, 
    boolean activo, int accesoNegadoContador, 
    long instanteBloqueo, long instanteUltimoAcceso) {
        this.mail = mail;
        this.clave = clave;
        this.id = id;
        this.creado = creado;
        this.activo = activo;
        this.accesoNegadoContador = accesoNegadoContador;
        this.instanteBloqueo = instanteBloqueo;
        this.instanteUltimoAcceso = instanteUltimoAcceso;
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreado() {
        return this.creado;
    }

    public void setCreado(long creado) {
        this.creado = creado;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public boolean getActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getAccesoNegadoContador() {
        return this.accesoNegadoContador;
    }

    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }

    public long getInstanteBloqueo() {
        return this.instanteBloqueo;
    }

    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }

    public long getInstanteUltimoAcceso() {
        return this.instanteUltimoAcceso;
    }

    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }

}
