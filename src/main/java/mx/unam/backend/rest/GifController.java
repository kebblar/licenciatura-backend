package mx.unam.backend.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Gif;
import mx.unam.backend.service.GifService;

/**
 * Implementacion del Controller de la entidad de 'Gif'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class GifController {

    private GifService cmtService;

    public GifController(GifService gif) {
        this.cmtService = gif;
    }

    @GetMapping(path = "/gif", produces = "application/json; charset=utf-8")
    public List<Gif> getGifs(String gif_id) throws ServiceException {
        return cmtService.solicitaGifs(gif_id);
    }

    @PostMapping(path = "/gif", produces = "application/json; charset=utf-8")
    public Integer actualizaGif(@RequestBody Gif p) {
        return cmtService.actualizaGif(p);
    }

    @DeleteMapping(path = "/gif", produces = "application/json; charset=utf-8")
    public void borraGif(String cmtId) {
        cmtService.borraGif(cmtId);
    }

}
