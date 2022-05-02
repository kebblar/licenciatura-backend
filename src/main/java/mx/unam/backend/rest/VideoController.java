package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.unam.backend.model.Video;

/**
 * Implementacion del Controller de la entidad de 'Video'.
 *
 * @author  Gerardo García
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class VideoController {

	private Video video;

	public VideoController(Video video){
		this.video=video;
	}

	// @GetMapping(
 //        	path = "/publicar",
 //        	produces = "application/json; charset=utf-8")
 //    public Publicacion publicar(@RequestBody PublicacionService p){
 //    	return publicacion.inserta(p);
 //    }

    @PostMapping(
        	path = "/video",
        	produces = "application/json; charset=utf-8")
    public Video actualizaVideo(@RequestBody Video p){
    	return video.actualiza(p);
    }

    @PutMapping(
        	path = "/video",
        	produces = "application/json; charset=utf-8")
    public Video creaVideo(@RequestBody Video p){
    	return video.inserta(p);
    }


    @DeleteMapping(
        	path = "/video",
        	produces = "application/json; charset=utf-8")
    public Video borraVideo(@RequestBody Video p){
    	return video.borra(p);
    }

    
}
