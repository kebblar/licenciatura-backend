/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      RecuperacionTokenRequest
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 11 Mar 2022
 */
package mx.unam.backend.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Implementacion del POJO de la entidad de 'RecuperacionTokenRequest'.
 *
 * @author  mentesniker
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecuperacionTokenRequest {

    /*
     * Atributos de la clase.
     */
    private String token;
    private String claveNueva;
}
