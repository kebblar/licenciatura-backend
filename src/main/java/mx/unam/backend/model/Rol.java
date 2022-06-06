/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Rol
 * Autor:       garellano
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Rol class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    /*
     * Atributos de la clase.
     */
    private int id;
    private String nombre;
    private boolean activo;

}
