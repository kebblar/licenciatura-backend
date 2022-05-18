/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        interface
 * Nombre:      LoginService
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Publicacion;

/**
 * <p>
 * Definición de la interfaz de servicios para 'Login'.
 *
 * @author Gerardo García
 * @see mx.unam.backend.model.Publicacion
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface PublicacionService {

    /**
     * Solicita la generacion de un publicacion.
     * el metodo regresa una instancia de {@link Publicacion} que
     * tiene todos sus valores por defecto.
     *
     * @param in String asociado al publicacion asociado
     * @return objeto de la clase {@link Publicacion}
     * @throws ServiceException if any
     * @throws SQLException
     */
    Integer inserta(Publicacion in) throws ServiceException, SQLException;

    Publicacion solicitarPublicacion(int comentId) throws ServiceException;

    Integer actualizaPublicacion(Publicacion in);

    List<Publicacion> solicitaPublicacions(int publicacion_id) throws ServiceException;

    void borraPublicacion(int cmtId);

}