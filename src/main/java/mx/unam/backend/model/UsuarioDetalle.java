/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UsuarioDetalle
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:38
 */
package mx.unam.backend.model;

import java.util.Date;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'UsuarioDetalle'.
 *
 * @author  luz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class UsuarioDetalle {

    /*
     * Atributos de clase.
     */
    private int id;
    private String nombre;
    private String segundoApellido;
    private String primerApellido;
    private Date fechaNacimiento;
    private String nickName;
    private String telefonoCelular;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioDetalle() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param id a int.
     * @param nombre a {@link java.lang.String} object.
     * @param segundoApellido a {@link java.lang.String} object.
     * @param primerApellido a {@link java.lang.String} object.
     * @param nickName a {@link java.lang.String} object.
     * @param fechaNacimiento a {@link java.util.Date} object.
     * @param telefonoCelular a {@link java.lang.String} object.
     */
    public UsuarioDetalle(
            int id,
            String nombre,
            String segundoApellido,
            String primerApellido,
            String nickName,
            Date fechaNacimiento,
            String telefonoCelular) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.segundoApellido = segundoApellido;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCelular = telefonoCelular;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
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
     * <p>Getter for the field <code>nombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     *
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Getter for the field <code>segundoApellido</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getsegundoApellido() {
        return segundoApellido;
    }

    /**
     * <p>Setter for the field <code>segundoApellido</code>.</p>
     *
     * @param segundoApellido a {@link java.lang.String} object.
     */
    public void setsegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * <p>Getter for the field <code>primerApellido</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getprimerApellido() {
        return primerApellido;
    }

    /**
     * <p>Setter for the field <code>primerApellido</code>.</p>
     *
     * @param primerApellido a {@link java.lang.String} object.
     */
    public void setprimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * <p>Getter for the field <code>fechaNacimiento</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * <p>Setter for the field <code>fechaNacimiento</code>.</p>
     *
     * @param fechaNacimiento a {@link java.util.Date} object.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * <p>Getter for the field <code>nickName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * <p>Setter for the field <code>nickName</code>.</p>
     *
     * @param nickName a {@link java.lang.String} object.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * <p>Getter for the field <code>telefonoCelular</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    /**
     * <p>Setter for the field <code>telefonoCelular</code>.</p>
     *
     * @param telefonoCelular a {@link java.lang.String} object.
     */
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * <p>getHash.</p>
     *
     * @return a long.
     */
    public long getHash() {
        return hashCode();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "UsuarioDetalle [id=" + id + ", nombre=" + nombre + ", segundoApellido=" + segundoApellido
                + ", primerApellido=" + primerApellido + ", fechaNacimiento=" + fechaNacimiento + ", nickName="
                + nickName + ", telefonoCelular=" + telefonoCelular + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((primerApellido == null) ? 0 : primerApellido.hashCode());
        result = prime * result + ((segundoApellido == null) ? 0 : segundoApellido.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + id;
        result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefonoCelular == null) ? 0 : telefonoCelular.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDetalle)) return false;
        UsuarioDetalle that = (UsuarioDetalle) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(segundoApellido, that.segundoApellido)
                && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento)
                && Objects.equals(nickName, that.nickName) && Objects.equals(telefonoCelular, that.telefonoCelular);
    }
}

