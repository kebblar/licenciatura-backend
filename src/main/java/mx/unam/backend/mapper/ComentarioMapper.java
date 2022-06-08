package mx.unam.backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.exceptions.PersistenceException;

import mx.unam.backend.model.Comentario;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Comentario.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Mapper
public interface ComentarioMapper {

        /**
         * Regresa una lista con todos los comentarios de una publicacio dada
         *
         * @param publicacion_id el id de la publicacion
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Comentario} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "ComentarioMap", value = {
                        @Result(property = "comentarioId", column = "comentario_id"),
                        @Result(property = "usuarioCreadorId", column = "usuario_id"),
                        @Result(property = "publicacionId", column = "publicacion_id"),
                        @Result(property = "comentario", column = "comentario"),
                        @Result(property = "fechaCreacion", column = "fecha_creacion") })
        @Select("SELECT * FROM comentario WHERE publicacion_id = #{publicacion_id};")
        List<Comentario> getComentarios(@Param("publicacion_id") int publicacion_id) throws PersistenceException;

        /**
         * Inserta un comentario en la tabla
         *
         * @param cmt el comentario a insertar
         * @return Entero que indica que la operación salió bien
         * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en
         *                               esta operación desde la base de datos
         */
        @Insert("INSERT INTO comentario VALUES(#{comentarioId},"
                        + " #{publicacionId}, "
                        + " #{usuarioCreadorId}, "
                        + " #{comentario}, "
                        + " #{fechaCreacion})")
        int insertComentario(Comentario cmt) throws SQLException;

        /**
         * Actualiza un objeto de tipo '{@link mx.unam.backend.model.Comentario} ' con
         * base en la informacion dada por el objeto de tipo 'comentario'.
         *
         * @param cmt objeto de tipo '{@link mx.unam.backend.model.Comentario} ' a ser
         *            actualizado.
         * @return el numero de registros actualizados.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Update(value = "UPDATE comentario "
                        + "SET comentario = #{comentario}, "
                        + "fecha_creacion = #{fechaCreacion} "
                        + "WHERE comentario_id = #{comentarioId};")
        Integer updateComentario(Comentario cmt) throws PersistenceException;

        /**
         * Elimina un comentario a partir de su id
         *
         * @param cmtId el id del comentario a eliminar
         * @return
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM comentario WHERE comentario_id = #{comentario_id};")
        Integer deleteComentario(@Param("comentario_id") int cmtId) throws PersistenceException;

        /**
         * Elimina todos los comentarios de una publicación
         *
         * @param cmtId el id del comentario a eliminar
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM comentario WHERE publicacion_id = #{publicacion_id};")
        Integer deleteAllComentarios(@Param("publicacion_id") int cmtId) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Comentario} '
         * contenido en la base de datos usando su id.
         *
         * @param publicacionId el id del comentario a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Comentario} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("ComentarioMap")
        @Select("SELECT * FROM comentario WHERE comentario_id = #{comentario_id};")
        Comentario getByComentarioId(@Param("comentario_id") int publicacionId) throws PersistenceException;
}
