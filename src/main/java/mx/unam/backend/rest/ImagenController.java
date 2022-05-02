package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.PostMapping;
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

	private ImagenService imagen;

	public ImagenController(ImagenService imagen){
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
    public Imagen actualizaImagen(@RequestBody ImagenService p){
    	return imagen.actualiza(p);
    }

    @PutMapping(
        	path = "/imagen",
        	produces = "application/json; charset=utf-8")
    public Imagen creaImagen(@RequestBody ImagenService p){
    	return imagen.inserta(p);
    }


    @DeleteMapping(
        	path = "/imagen",
        	produces = "application/json; charset=utf-8")
    public Imagen borraImagen(@RequestBody ImagenService p){
    	return imagen.borra(p);
    }

    
}
