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

import mx.unam.backend.model.Video;

import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Video.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Repository
public interface VideoMapper {

        /**
         * Regresa una lista con todas las videoes de una publicacion dada
         *
         * @param publicacion_id el id de la publicacion
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Video} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "VideoMap", value = {
                        @Result(property = "id", column = "video_id"),
                        @Result(property = "video", column = "video") })
        @Select("SELECT * FROM video WHERE publicacion_id = #{publicacion_id};")
        List<Video> getVideosPublicacion(@Param("publicacion_id") String publicacion_id) throws PersistenceException;

        /**
         * Regresa una lista con todas las videoes de un usuario dado
         *
         * @param usuario_id el id del usuario
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Video} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "VideosMapUsuario", value = {
                        @Result(property = "videoId", column = "video_id"),
                        @Result(property = "video", column = "video") })
        @Select("SELECT * FROM video WHERE usuario_id = #{usuario_id};")
        List<Video> getVideosUsuario(@Param("usuario_id") Integer usuario_id) throws PersistenceException;

        /**
         * Actualiza un objeto de tipo '{@link mx.unam.backend.model.Video} ' con
         * base en la informacion dada por el objeto de tipo 'video'.
         *
         * @param img objeto de tipo '{@link mx.unam.backend.model.Video} ' a ser
         *            actualizado.
         * @return el numero de registros actualizados.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Update(value = "UPDATE video "
                        + "SET video = #{video}, "
                        + "WHERE video_id = #{videoId};")
        Integer updateVideo(Video img) throws PersistenceException;

        /**
         * Elimina una video a partir de su id
         *
         * @param cmtId el id de la video a eliminar
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM video WHERE video_id = #{video_id};")
        void deleteVideo(@Param("video_id") String cmtId) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Video} '
         * contenido en la base de datos usando su id.
         *
         * @param imagenId el id del comentario a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Video} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("VideoMap")
        @Select("SELECT FROM video WHERE video_id = #{video_id};")
        Video getByVideoId(@Param("video_id") String imagenId) throws PersistenceException;
}