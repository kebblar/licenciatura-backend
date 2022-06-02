/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      LoginServiceImpl
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.PublicacionMapper;
import mx.unam.backend.model.Publicacion;

/**
 * <p>
 * Implementación de la interfaz
 * {@link mx.unam.backend.service.PublicacionService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan
 * {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author Gerardo Garcia
 * @see unam.mx.backend.domain.Publicacion
 * @see mx.unam.backend.service.PublicacionService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class PublicacionServiceImpl implements PublicacionService {

    private PublicacionMapper cmt;

    public PublicacionServiceImpl(PublicacionMapper cmt) {
        this.cmt = cmt;
    }

    @Override
    public Publicacion solicitarPublicacion(int publicacionId) {
        return cmt.getByPublicacionId(publicacionId);
    }

    @Override
    public Integer inserta(Publicacion in) throws SQLException {
        return cmt.insertPublicacion(in);
    }

    @Override
    public List<Publicacion> solicitaPublicacions(int publicacion_id) throws ServiceException {
        return cmt.getPublicaciones(publicacion_id);
    }

    @Override
    public Integer actualizaPublicacion(Publicacion in) {
        return cmt.updatePublicacion(in);
    }

    @Override
    public Integer borraPublicacion(int cmtId) {
        return cmt.deletePublicacion(cmtId);
    }

}