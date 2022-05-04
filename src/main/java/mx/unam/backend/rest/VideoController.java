package mx.unam.backend.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Video;
import mx.unam.backend.service.VideoService;

/**
 * Implementacion del Controller de la entidad de 'Video'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class VideoController {

    private VideoService cmtService;

    public VideoController(VideoService video) {
        this.cmtService = video;
    }

    @GetMapping(path = "/video", produces = "application/json; charset=utf-8")
    public List<Video> getVideos(String video_id) throws ServiceException {
        return cmtService.solicitaVideos(video_id);
    }

    @PostMapping(path = "/video", produces = "application/json; charset=utf-8")
    public Integer actualizaVideo(@RequestBody Video p) {
        return cmtService.actualizaVideo(p);
    }

    @DeleteMapping(path = "/video", produces = "application/json; charset=utf-8")
    public void borraVideo(String cmtId) {
        cmtService.borraVideo(cmtId);
    }

}
