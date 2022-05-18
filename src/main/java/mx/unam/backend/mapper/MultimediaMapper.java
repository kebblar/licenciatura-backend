package mx.unam.backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Repository;

import mx.unam.backend.model.Multimedia;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Multimedia.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Repository
public interface MultimediaMapper {

        /**
         * Regresa una lista con todas las multimedias de una publicacion dada
         *
         * @param publicacion_id el id de la publicacion
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Multimedia} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "MultimediaMap", value = {
                        @Result(property = "id", column = "multimedia_id"),
                        @Result(property = "multimedia", column = "multimedia") })
        @Select("SELECT * FROM multimedia WHERE publicacion_id = #{publicacion_id};")
        List<Multimedia> getMultimediasPublicacion(@Param("publicacion_id") int publicacion_id)
                        throws PersistenceException;

        /**
         * Regresa una lista con todas las multimediaes de un usuario dado
         *
         * @param usuario_id el id del usuario
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Multimedia} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "MultimediaMapUsuario", value = {
                        @Result(property = "multimediaId", column = "multimedia_id"),
                        @Result(property = "publicacionId", column = "publicacion_id"),
                        @Result(property = "multimedia", column = "multimedia"),
                        @Result(property = "esVideo", column = "es_video") })
        @Select("SELECT * FROM multimedia WHERE usuario_id = #{usuario_id};")
        List<Multimedia> getMultimediasUsuario(@Param("usuario_id") int usuarioId) throws PersistenceException;

        /**
         * Inserta un multimedia en la tabla
         *
         * @param cmt el multimedia a insertar
         * @return Entero que indica que la operación salió bien
         * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en
         *                               esta operación desde la base de datos
         */
        @Insert("INSERT INTO multimedia VALUES(#{multimediaId},"
                        + " #{publicacionId}, "
                        + " #{usuarioCreadorId}, "
                        + " #{multimedia}, "
                        + " #{esVideo})")
        int insertMultimedia(Multimedia cmt) throws SQLException;

        /**
         * Elimina una multimedia a aprtir de su id
         *
         * @param cmtId el id de la multimedia a eliminar
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM multimedia WHERE multimedia_id = #{multimedia_id};")
        void deleteMultimedia(@Param("multimedia_id") int cmtId) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Multimedia} '
         * contenido en la base de datos usando su id.
         *
         * @param imagenId el id del multimedia a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Multimedia} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("MultimediaMap")
        @Select("SELECT FROM multimedia WHERE multimedia_id = #{multimedia_id} and es_video = false;")
        Multimedia getByImagenId(@Param("multimedia_id") int multimediaId) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Multimedia} '
         * contenido en la base de datos usando su id.
         *
         * @param imagenId el id del multimedia a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Multimedia} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("MultimediaMap")
        @Select("SELECT FROM multimedia WHERE multimedia_id = #{multimedia_id} and es_video = true;")
        Multimedia getByVideoId(@Param("multimedia_id") int multimediaId) throws PersistenceException;
}