package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.unam.backend.model.Gif;

/**
 * Implementacion del Controller de la entidad de 'Gif'.
 *
 * @author  Gerardo García
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class GifController {

	private GifService gif;

	public GifController(GifService gif){
		this.gif=gif;
	}

	// @GetMapping(
 //        	path = "/publicar",
 //        	produces = "application/json; charset=utf-8")
 //    public Publicacion publicar(@RequestBody PublicacionService p){
 //    	return publicacion.inserta(p);
 //    }

    @PostMapping(
        	path = "/gif",
        	produces = "application/json; charset=utf-8")
    public Gif actualizaGif(@RequestBody GifService p){
    	return gif.actualiza(p);
    }

    @PutMapping(
        	path = "/gif",
        	produces = "application/json; charset=utf-8")
    public Gif creaGif(@RequestBody GifService p){
    	return gif.inserta(p);
    }


    @DeleteMapping(
        	path = "/gif",
        	produces = "application/json; charset=utf-8")
    public Gif borraGif(@RequestBody GifService p){
    	return gif.borra(p);
    }

    
}
