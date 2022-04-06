package mx.unam.backend.mapper;

/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      UsuarioDetalleMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:21
 */

import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import mx.unam.backend.model.UsuarioDetalle;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface UsuarioDetalleMapper {

    /**
     * Inserta un objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}  con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuarioDetalle(idUsuario, nombre, segundoApellido, primerApellido, nickName, fechaNacimiento, telefonoCelular) VALUES(#{id}, #{nombre}, #{segundoApellido}, #{primerApellido}, #{nickName}, #{fechaNacimiento}, #{telefonoCelular} )")
    Integer insert(UsuarioDetalle usuarioDetalle) throws SQLException;

}