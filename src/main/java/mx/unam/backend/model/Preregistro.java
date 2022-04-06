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
/**
 * <p>Preregistro class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */

public class Preregistro {
    
    private int id;

    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    private String correo;

    @ApiModelProperty(example = "Hola1234#")
    private String claveHash = "";

    @ApiModelProperty(example = "5543562126")
    private String telefono;

    private Date fechaNacimiento;

    private String randomString;

    private long instanteRegistro;

    private String nombre;

    private String segundoApellido;

    private String primerApellido;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaveHash() {
        return this.claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRandomString() {
        return this.randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public long getInstanteRegistro() {
        return this.instanteRegistro;
    }

    public void setInstanteRegistro(long instanteRegistro) {
        this.instanteRegistro = instanteRegistro;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }


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
