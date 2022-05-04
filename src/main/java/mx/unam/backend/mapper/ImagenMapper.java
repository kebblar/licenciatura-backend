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

import mx.unam.backend.model.Imagen;

import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface 'Mapper' MyBatis asociado a la entidad Imagen.
 *
 * @author Santiago Arroyo
 * @version 0.1.1-SNAPSHOT
 */
@Repository
public interface ImagenMapper {

        /**
         * Regresa una lista con todas las imagenes de una publicacion dada
         *
         * @param publicacion_id el id de la publicacion
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Imagen} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "ImagenesMapPublicacion", value = {
                        @Result(property = "id", column = "imagen_id"),
                        @Result(property = "imagen", column = "imagen") })
        @Select("SELECT * FROM imagen WHERE publicacion_id = #{publicacion_id};")
        List<Imagen> getImagenesPublicacion(@Param("publicacion_id") String publicacion_id)
                        throws PersistenceException;

        /**
         * Regresa una lista con todas las imagenes de un usuario dado
         *
         * @param usuario_id el id del usuario
         * @return una lista de objetos de tipo
         *         '{@link mx.unam.backend.model.Imagen} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Results(id = "ImagenMap", value = {
                        @Result(property = "id", column = "imagen_id"),
                        @Result(property = "imagen", column = "imagen") })
        @Select("SELECT * FROM imagen WHERE usuario_id = #{usuario_id};")
        List<Imagen> getImagenesUsuario(@Param("usuario_id") Integer usuario_id) throws PersistenceException;

        /**
         * Actualiza un objeto de tipo '{@link mx.unam.backend.model.Imagen} ' con
         * base en la informacion dada por el objeto de tipo 'imagen'.
         *
         * @param img objeto de tipo '{@link mx.unam.backend.model.Imagen} ' a ser
         *            actualizado.
         * @return el numero de registros actualizados.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Update(value = "UPDATE imagen "
                        + "SET imagen = #{imagen}, "
                        + "WHERE imagen_id = #{imagenId};")
        Integer updateImagen(Imagen img) throws PersistenceException;

        /**
         * Elimina una imagen a aprtir de su id
         *
         * @param cmtId el id de la imagen a eliminar
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @Delete("DELETE FROM imagen WHERE imagen_id = #{imagen_id};")
        void deleteImagen(@Param("imagen_id") String cmtId) throws PersistenceException;

        /**
         * Busca un objeto de tipo '{@link mx.unam.backend.model.Imagen} '
         * contenido en la base de datos usando su id.
         *
         * @param imagenId el id del comentario a buscar
         * @return un objeto de tipo '{@link mx.unam.backend.model.Imagen} '.
         * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un
         *                                       error en esta operación desde la base
         *                                       de datos.
         */
        @ResultMap("ImagenMap")
        @Select("SELECT FROM imagen WHERE imagen_id = #{imagen_id};")
        Imagen getByImagenId(@Param("imagen_id") String imagenId) throws PersistenceException;
}