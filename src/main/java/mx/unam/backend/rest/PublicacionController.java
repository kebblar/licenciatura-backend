package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Publicacion;
import mx.unam.backend.service.PublicacionService;

/**
 * Implementacion del Controller de la entidad de 'Publicacion'.
 *
 * @author  Gerardo García
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class PublicacionController {

	private PublicacionService publicacion;

	public PublicacionController(PublicacionService publicacion){
		this.publicacion=publicacion;
	}

	// @GetMapping(
 //        	path = "/publicar",
 //        	produces = "application/json; charset=utf-8")
 //    public Publicacion publicar(@RequestBody PublicacionService p){
 //    	return publicacion.inserta(p);
 //    }

    @PostMapping(
        	path = "/publicar",
        	produces = "application/json; charset=utf-8")
    public int actualizaPublicacion(@RequestBody Publicacion p) throws ServiceException{
    	return publicacion.actualiza(p);
    }

    // @PutMapping(
    //     	path = "/publicar",
    //     	produces = "application/json; charset=utf-8")
    // public Publicacion creaPublicacion(@RequestBody PublicacionService p){
    // 	return publicacion.inserta(p);
    // }


    @DeleteMapping(
        	path = "/publicar",
        	produces = "application/json; charset=utf-8")
    public int borraPublicacion(@RequestBody int p) throws ServiceException{
    	return publicacion.borra(p);
    }

    
}
