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

}
