package mx.unam.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoUsuario {

    private int id;
    private String mail;
    private String clave;
    private long creado;

}
