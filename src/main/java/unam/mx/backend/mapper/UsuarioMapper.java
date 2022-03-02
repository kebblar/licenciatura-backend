package unam.mx.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.exceptions.PersistenceException;

import unam.mx.backend.model.Usuario;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface UsuarioMapper {

    @Results(id="UsuarioMap", value = {
        @Result(property = "id",   column = "id"),
        @Result(property = "mail",   column = "mail"),
        @Result(property = "clave",   column = "clave"),    
        @Result(property = "creado",   column = "creado"),
        @Result(property = "activo",   column = "activo"),
        @Result(property = "accesoNegadoContador",   column = "accesoNegadoContador"),
        @Result(property = "instanteBloqueo",   column = "instanteBloqueo"),
        @Result(property = "instanteUltimoAcceso",   column = "instanteUltimoAcceso"),
    })
    @Select("SELECT * FROM usuario WHERE mail = #{mail};")
    Usuario getbyMail(String mail) throws PersistenceException;

    /**
     * Actualiza un objeto de tipo 'usuario' con base en la infrmación dada por el objeto de tipo 'usuario'.
     *
     * @param usr a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario SET mail = #{mail}, clave = #{clave}, creado = #{creado}, activo = #{activo}, "
            + "accesoNegadoContador = #{accesoNegadoContador}, instanteBloqueo = #{instanteBloqueo}, "
            + "instanteUltimoAcceso = #{instanteUltimoAcceso} "
            + "WHERE id = #{id}; ")
    int update(Usuario usr) throws PersistenceException;
}
