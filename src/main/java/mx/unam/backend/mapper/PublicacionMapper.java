package mx.unam.backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Repository;

import mx.unam.backend.model.Publicacion;

import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Publicacion.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Repository
public interface PublicacionMapper {

        /**
         * Regresa una lista con todas las publicaciones de un usuario dado
         *
         * @param usuario_id el id del usuario a buscar
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Publicacion} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "PublicacionesMap", value = {
                        @Result(property = "id", column = "publicacion_id"),
                        @Result(property = "nombre", column = "nombre"),
                        @Result(property = "activo", column = "activo") })
        @Select("SELECT * FROM publicacion WHERE usuario_id = #{usuario_id};")
        List<Publicacion> getPublicaciones(@Param("usuario_id") Integer usuario_id) throws PersistenceException;

        /**
         * Actualiza un objeto de tipo '{@link mx.unam.backend.model.Publicacion} ' con
         * base en la informacion dada por el objeto de tipo 'publicacion'.
         *
         * @param pub objeto de tipo '{@link mx.unam.backend.model.Publicacion} ' a ser
         *            actualizado.
         * @return el numero de registros actualizados.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Update(value = "UPDATE publicacion "
                        + "SET texto_publicacion = #{texto_publicacion}, "
                        + "fecha_creacion = #{fecha_creacion}, "
                        + "es_publica = #{es_publica} "
                        + "WHERE publicacion_id = #{publicacion_id};")
        Integer updatePublicacion(Publicacion pub) throws PersistenceException;

        /**
         * Elimina una publicacion a partir de su id
         *
         * @param publicacion_id el id de la publicacion a buscar.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM publicacion WHERE publicacion_id = #{publicacion_id};")
        void deletePublicacion(@Param("publicacion_id") Integer publicacion_id) throws PersistenceException;;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Publicacion} '
         * contenido en
         * la base de datos usando su id.
         *
         * @param publicacion_id el id de la publicacion a buscar.
         * @return un objeto de tipo '{@link mx.unam.backend.model.Publicacion} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("PublicacionMap")
        @Select("SELECT FROM publicacion WHERE publicacion_id = #{publicacion_id};")
        Publicacion getByPublicacionId(@Param("publicacion_id") Integer publicacion_id) throws PersistenceException;
}
