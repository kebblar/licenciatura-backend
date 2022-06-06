package mx.unam.backend.model;

/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Preregistro
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:35
 */

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Preregistro class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preregistro {
    
    private int id;

    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    private String correo;

    @ApiModelProperty(example = "Hola1234#")
    private String claveHash = "";

    @ApiModelProperty(example = "'5543562126'")
    private String telefono;

    private Date fechaNacimiento;

    private String randomString;

    private long instanteRegistro;

    private String nombre;

    private String segundoApellido;

    private String primerApellido;

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
     * <p>Getter para el atributo <code>nick</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getNick() {
        return this.nick;
    }
    /**
     * <p>Setter para el atributo <code>nick</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setNick(String nick) {
        this.nick = nick;
    }
     /**
     * <p>Getter para el atributo <code>correo</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getCorreo() {
        return this.correo;
    }
    /**
     * <p>Setter para el atributo <code>correo</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
/**
     * <p>Getter para el atributo <code>claveHash</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getClaveHash() {
        return this.claveHash;
    }
    /**
     * <p>Setter para el atributo <code>claveHash</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }
    /**
     * <p>Getter para el atributo <code>telefono</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getTelefono() {
        return this.telefono;
    }
    /**
     * <p>Setter para el atributo <code>telefono</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * <p>Getter para el atributo <code>fechaNacimiento</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    /**
     * <p>Setter para el atributo <code>fechaNacimiento</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
     /**
     * <p>Getter para el atributo <code>randomSring</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getRandomString() {
        return this.randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
    /**
     * <p>Setter para el atributo <code>RandomString</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public long getInstanteRegistro() {
        return this.instanteRegistro;
    }
    /**
     * <p>Getter para el atributo <code>instanteRegistro</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setInstanteRegistro(long instanteRegistro) {
        this.instanteRegistro = instanteRegistro;
    }
    /**
     * <p>Setter para el atributo <code>instanteRegistro</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * <p>Setter para el atributo <code>nombre</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * <p>Getter para el atributo <code>segundoApellido</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    /**
     * <p>Setter para el atributo <codesegundoApellido</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    /**
     * <p>Getter para el atributo <code>primerApellido</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public String getPrimerApellido() {
        return this.primerApellido;
    }
     /**
     * <p>Setter para el atributo <code>primerApellido</code>.</p>
     *
     * @return un objeto de tipo {@link java.lang.String}.
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    /**	
     * Crea un preregistro con el parametros (int id,String, nick, etc)
     * @param int id
     * @param String nick
     * @param String correo
     * @param String claveHash
     * @param String telefono
     * @param Date fechaNacimiento
     * @param String randomString
     * @param long instanteRegistro 
     * @param String nombre 
     * @param String segundoApellido
     * @param String primerApellido
     */	
    public Preregistro(int id, String nick, String correo, String claveHash, String telefono, Date fechaNacimiento, String randomString, long instanteRegistro, String nombre, String segundoApellido, String primerApellido) {
        this.id = id;
        this.nick = nick;
        this.correo = correo;
        this.claveHash = claveHash;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.randomString = randomString;
        this.instanteRegistro = instanteRegistro;
        this.nombre = nombre;
        this.segundoApellido = segundoApellido;
        this.primerApellido = primerApellido;
    }

}
