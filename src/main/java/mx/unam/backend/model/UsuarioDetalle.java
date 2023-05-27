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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Implementacion del POJO de la entidad de 'UsuarioDetalle'.
 *
 * @author luz
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
