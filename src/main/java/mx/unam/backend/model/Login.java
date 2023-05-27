/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      Login
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'Login'.
 *
 * @author mentesniker
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private int id;
    private String mail;
    private String jwt;
    private List<Rol> roles;


    /**
     * <p>Setter para el atributo <code>id</code>.</p>
     *
     * @param id un int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter para el atributo <code>id</code>.</p>
     *
     * @return un int.
     */
    public int getId() {
        return this.id;
    }

}
