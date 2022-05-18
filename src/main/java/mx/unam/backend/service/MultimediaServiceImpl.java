package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.MultimediaMapper;
import mx.unam.backend.model.Multimedia;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    // @Value("${app.destination.folder}")
    private String path;

    private MultimediaMapper img;

    public MultimediaServiceImpl(MultimediaMapper img) {
        this.img = img;
    }

    @Override
    public Multimedia solicitarImagen(int imagenId) {
        return img.getByImagenId(imagenId);
    }

    @Override
    public Multimedia solicitarVideo(int videoId) {
        return img.getByVideoId(videoId);
    }

    @Override
    public List<Multimedia> solicitaMultimedias(int publicacion_id) throws ServiceException {
        return img.getMultimediasPublicacion(publicacion_id);
    }

    @Override
    public void borraMultimedia(int cmtId) {
        img.deleteMultimedia(cmtId);
    }

    @Override
    public Integer creaMultimedia(Multimedia in) throws SQLException {
        return img.insertMultimedia(in);
    }
}
