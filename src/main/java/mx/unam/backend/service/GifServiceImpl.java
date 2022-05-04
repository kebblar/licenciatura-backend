package mx.unam.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.GifMapper;
import mx.unam.backend.model.Gif;

public class GifServiceImpl implements GifService {

    @Value("${app.destination.folder}")
    private String path;

    private GifMapper img;

    public GifServiceImpl(GifMapper img) {
        this.img = img;
    }

    @Override
    public Gif solicitarGif(String imagenId) {
        return img.getByGifId(imagenId);
    }

    @Override
    public List<Gif> solicitaGifs(String publicacion_id) throws ServiceException {
        return img.getGifsPublicacion(publicacion_id);
    }

    @Override
    public Integer actualizaGif(Gif in) {
        return img.updateGif(in);
    }

    @Override
    public void borraGif(String cmtId) {
        img.deleteGif(cmtId);
    }
}
