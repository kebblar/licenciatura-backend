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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.PublicacionMapper;
import mx.unam.backend.model.Publicacion;
import mx.unam.backend.utils.DigestEncoder;
import mx.unam.backend.utils.EnumMessage;
import mx.unam.backend.utils.HttpStatus;
import mx.unam.backend.utils.JWTUtil;
import mx.unam.backend.utils.StringUtils;

/**
 * <p>Implementación de la interfaz {@link mx.unam.backend.service.PublicacionService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author  Gerardo Garcia
 * @see     unam.mx.backend.domain.Publicacion
 * @see     mx.unam.backend.service.PublicacionService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class PublicacionServiceImpl implements PublicacionService{

    private PublicacionMapper publicacionMapper;
    private static final int RANDOM_STRING_LEN = 6;
    

    public PublicacionServiceImpl(PublicacionMapper publicacionMapper) {
        this.publicacionMapper = publicacionMapper;
    }

    /** {@inheritDoc} */
    // @Override
    // public int inserta(Publicacion publicacion) throws ServiceException {
    //     try {
    //         return 1;
    //     } catch (PersistenceException e1) {
    //         return 0;
    //         throw new ServiceException("Clave con error", "error al buscar un publicacion con el token", 2000, "intentelo de nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    /** {@inheritDoc} */
    @Override
    public int actualiza(Publicacion publicacion) throws ServiceException { 
       try {
            this.publicacionMapper.updatePublicacion(publicacion);
            return 1;
        } catch (PersistenceException e1) {
            throw new ServiceException("Error en actualizado", "error al actualizar", 2000, "intentelo de nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

     /** {@inheritDoc} */
    @Override
    public int borra(int publicacionId) throws ServiceException { 
       try {
            this.publicacionMapper.deletePublicacion(publicacionId);
            return 1;
        } catch (PersistenceException e1) {
            throw new ServiceException("Error en borrado", "error al borrar", 2000, "intentelo de nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    
}