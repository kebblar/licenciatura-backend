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
 * Nombre:      RegistroMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:38
 */
package mx.unam.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import mx.unam.backend.model.Preregistro;

import java.sql.SQLException;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Registro.
 *
 * @author Gustavo A. Arellano
 * @version 0.1.1-SNAPSHOT
 */
public interface RegistroMapper {

    /** Constant <code>CAMPOS_REG=" idUsuario, nick, correo, claveHash, telefono"{trunked}</code> */
    String CAMPOS_REG = " idUsuario, nick, correo, claveHash, telefono, fechaNacimiento, randomString, " +
            "instanteRegistro, nombre, primerApellido, segundoApellido ";

    /**
     * Recupera un elemento del preregistro utilizando el correo electrónico que ingresó.
     *
     * @param correo mail de registro
     * @return Objeto con la información de los datos del preregistro
     * @throws java.sql.SQLException En caso de que haya un problema con la consulta
     */
    @Results(id="RegistroMap", value = {
            @Result(property = "id",  column = "idUsuario"),
            @Result(property = "nick",      column = "nick"),
            @Result(property = "correo",    column = "correo"),
            @Result(property = "claveHash", column = "claveHash"),
            @Result(property = "telefono",  column = "telefono"),
            @Result(property = "fechaNacimiento",  column = "fechaNacimiento"),
            @Result(property = "randomString",     column = "randomString"),
            @Result(property = "instanteRegistro", column = "instanteRegistro"),
            @Result(property = "nombre",  column = "nombre"),
            @Result(property = "primerApellido",     column = "primerApellido"),
            @Result(property = "segundoApellido", column = "segundoApellido"),
          })
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE correo = #{correo} ")
    Preregistro getByMail(String correo) throws SQLException;

    /**
     * Recupera el registro por medio del código random generado.
     *
     * @param randomString código random generado
     * @return Objeto con la información de los datos del preregistro
     * @throws java.sql.SQLException En caso de que haya un problema con la consulta
     */
    @ResultMap("RegistroMap")
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE randomString = #{randomString} ")
    Preregistro getByRandomString(String randomString) throws SQLException;

    /**
     * Genera un usuario en la base de datos con los datos ya completos del preregistro.
     *
     * @param preregistro Datos de inscripción al sistema de un usuario
     * @return Entero que indica que la consulta tuvo éxito
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO preregistro(nick, claveHash, correo, telefono, fechaNacimiento, randomString, instanteRegistro, nombre, primerApellido, segundoApellido) " +
    "VALUES(#{nick}, #{claveHash}, #{correo}, #{telefono}, #{fechaNacimiento}, #{randomString}, #{instanteRegistro}, #{nombre}, #{primerApellido}, #{segundoApellido} )" +
    " ON DUPLICATE KEY UPDATE nick=#{nick}, telefono=#{telefono}, fechaNacimiento=#{fechaNacimiento},"+ 
    "claveHash=#{claveHash}, randomString=#{randomString}, instanteRegistro=#{instanteRegistro}, nombre=#{nombre}, primerApellido=#{primerApellido}, segundoApellido=#{segundoApellido}")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    Integer insertRegistro(Preregistro preregistro) throws SQLException;

    /**
     * Modifica un preregistro ya existente.
     *
     * @param registro Datos del registro que se desea modificar
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Update("UPDATE preregistro SET nick = #{nick}, telefono = #{telefono}, fechaNacimiento = #{fechaNacimiento}, claveHash = #{claveHash}, randomString = #{randomString},"+ 
    "instanteRegistro = #{instanteRegistro}, nombre=#{nombre}, primerApellido=#{primerApellido}, segundoApellido=#{segundoApellido} WHERE correo = #{correo} ")
    Integer update(Preregistro registro) throws SQLException;

    /**
     * Borra un preregistro existente por medio de su código.
     *
     * @param randomString Clave random asociada a un registro
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Select("DELETE FROM preregistro WHERE randomString = #{randomString} ")
    Integer deleteByRandomString(String randomString) throws SQLException;

}