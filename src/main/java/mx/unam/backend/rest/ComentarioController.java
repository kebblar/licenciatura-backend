package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.unam.backend.model.Comentario;

/**
 * Implementacion del Controller de la entidad de 'Comentario'.
 *
 * @author  Gerardo García
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class ComentarioController {

	private ComentarioService comentario;

	public ComentarioController(ComentarioService comentario){
		this.comentario=comentario;
	}

	// @GetMapping(
 //        	path = "/publicar",
 //        	produces = "application/json; charset=utf-8")
 //    public Publicacion publicar(@RequestBody PublicacionService p){
 //    	return publicacion.inserta(p);
 //    }

    @PostMapping(
        	path = "/comentario",
        	produces = "application/json; charset=utf-8")
    public Comentario actualizaComentario(@RequestBody ComentarioService p){
    	return comentario.actualiza(p);
    }

    @PutMapping(
        	path = "/comentario",
        	produces = "application/json; charset=utf-8")
    public Comentario creaComentario(@RequestBody ComentarioService p){
    	return comentario.inserta(p);
    }


    @DeleteMapping(
        	path = "/comentario",
        	produces = "application/json; charset=utf-8")
    public Comentario borraComentario(@RequestBody ComentarioService p){
    	return comentario.borra(p);
    }

    
}
