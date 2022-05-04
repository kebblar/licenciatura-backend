package mx.unam.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.VideoMapper;
import mx.unam.backend.model.Video;

public class VideoServiceImpl implements VideoService {

    @Value("${app.destination.folder}")
    private String path;

    private VideoMapper img;

    public VideoServiceImpl(VideoMapper img) {
        this.img = img;
    }

    @Override
    public Video solicitarVideo(String imagenId) {
        return img.getByVideoId(imagenId);
    }

    @Override
    public List<Video> solicitaVideos(String publicacion_id) throws ServiceException {
        return img.getVideosPublicacion(publicacion_id);
    }

    @Override
    public Integer actualizaVideo(Video in) {
        return img.updateVideo(in);
    }

    @Override
    public void borraVideo(String cmtId) {
        img.deleteVideo(cmtId);
    }
}
