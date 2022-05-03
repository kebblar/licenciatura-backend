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

import mx.unam.backend.model.Gif;

import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Gif.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Repository
public interface GifMapper {

        /**
         * Regresa una lista con todas las gifs de una publicacion dada
         *
         * @param publicacion_id el id de la publicacion
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Gif} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "GifsMapPublicacion", value = {
                        @Result(property = "id", column = "gif_id"),
                        @Result(property = "gif", column = "gif") })
        @Select("SELECT * FROM gif WHERE publicacion_id = #{publicacion_id};")
        List<Gif> getGifsPublicacion(@Param("publicacion_id") Integer publicacion_id) throws PersistenceException;

        /**
         * Regresa una lista con todas las gifes de un usuario dado
         *
         * @param usuario_id el id del usuario
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Gif} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "GifsMapUsuario", value = {
                        @Result(property = "gifId", column = "gif_id"),
                        @Result(property = "gif", column = "gif") })
        @Select("SELECT * FROM gif WHERE usuario_id = #{usuario_id};")
        List<Gif> getGifsUsuario(@Param("usuario_id") Integer usuario_id) throws PersistenceException;

        /**
         * Actualiza un objeto de tipo '{@link mx.unam.backend.model.Gif} ' con
         * base en la informacion dada por el objeto de tipo 'gif'.
         *
         * @param gif objeto de tipo '{@link mx.unam.backend.model.Gif} ' a ser
         *            actualizado.
         * @return el numero de registros actualizados.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Update(value = "UPDATE gif "
                        + "SET gif = #{gif}, "
                        + "WHERE gif_id = #{gifId};")
        Integer updateGif(Gif gif) throws PersistenceException;

        /**
         * Elimina una gif a aprtir de su id
         *
         * @param gif_id el id de la gif a eliminar
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM gif WHERE gif_id = #{gif_id};")
        void deleteGif(@Param("gif_id") Integer gif_id) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Gif} '
         * contenido en la base de datos usando su id.
         *
         * @param gif_id el id del comentario a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Gif} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("GifMap")
        @Select("SELECT FROM gif WHERE gif_id = #{gif_id};")
        Gif getByGifId(@Param("gif_id") Integer gif_id) throws PersistenceException;
}