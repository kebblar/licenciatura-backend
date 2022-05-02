package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.unam.backend.model.Imagen;

/**
 * Implementacion del Controller de la entidad de 'Imagen'.
 *
 * @author  Gerardo García
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class ImagenController {

	private Imagen imagen;

	public ImagenController(Imagen imagen){
		this.imagen=imagen;
	}

	// @GetMapping(
 //        	path = "/publicar",
 //        	produces = "application/json; charset=utf-8")
 //    public Publicacion publicar(@RequestBody PublicacionService p){
 //    	return publicacion.inserta(p);
 //    }

    @PostMapping(
        	path = "/imagen",
        	produces = "application/json; charset=utf-8")
    public Imagen actualizaImagen(@RequestBody Imagen p){
    	return imagen.actualiza(p);
    }

    @PutMapping(
        	path = "/imagen",
        	produces = "application/json; charset=utf-8")
    public Imagen creaImagen(@RequestBody Imagen p){
    	return imagen.inserta(p);
    }


    @DeleteMapping(
        	path = "/imagen",
        	produces = "application/json; charset=utf-8")
    public Imagen borraImagen(@RequestBody Imagen p){
    	return imagen.borra(p);
    }

    
}
