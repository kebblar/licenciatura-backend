package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.MultimediaMapper;
import mx.unam.backend.model.Multimedia;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    private MultimediaMapper img;

    public MultimediaServiceImpl(MultimediaMapper img) {
        this.img = img;
    }

    @Override
    public Multimedia solicitarImagen(Integer imagenId) {
        return img.getByImagenId(imagenId);
    }

    @Override
    public Multimedia solicitarVideo(Integer videoId) {
        return img.getByVideoId(videoId);
    }

    @Override
    public List<Multimedia> solicitaMultimedias(Integer publicacion_id) throws ServiceException {
        return img.getMultimediasPublicacion(publicacion_id);
    }

    @Override
    public Integer borraMultimedia(Integer cmtId) {
        return img.deleteMultimedia(cmtId);
    }

    @Override
    public Integer creaMultimedia(Multimedia in) throws SQLException {
        return img.insertMultimedia(in);
    }

    @Override
    public Integer actualizaMultimedia(Multimedia in) {
        return img.updateMultimedia(in);
    }
}
