/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      ImagenServiceImpl
 * Autor:       Noyola Alejandro
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
package mx.unam.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.ImagenMapper;
import mx.unam.backend.model.Imagen;

/**
 * <p>
 * Implementación de la interfaz {@link mx.unam.backend.service.ImagenService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan
 * {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author Gerardo Garcia
 * @see unam.mx.backend.domain.Imagen
 * @see mx.unam.backend.service.ImagenService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class ImagenServiceImpl implements ImagenService {

    // @Value("${app.destination.folder}")
    private String path;

    private ImagenMapper img;

    public ImagenServiceImpl(ImagenMapper img) {
        this.img = img;
    }

    @Override
    public Imagen solicitarImagen(String imagenId) {
        return img.getByImagenId(imagenId);
    }

    @Override
    public List<Imagen> solicitaImagenes(String publicacion_id) throws ServiceException {
        return img.getImagenesPublicacion(publicacion_id);
    }

    @Override
    public Integer actualizaImagen(Imagen in) {
        return img.updateImagen(in);
    }

    @Override
    public void borraImagen(String cmtId) {
        img.deleteImagen(cmtId);
    }

}
