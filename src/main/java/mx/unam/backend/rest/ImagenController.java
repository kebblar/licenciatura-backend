package mx.unam.backend.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Imagen;
import mx.unam.backend.service.ImagenService;

/**
 * Implementacion del Controller de la entidad de 'Imagen'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class ImagenController {

    private ImagenService cmtService;

    public ImagenController(ImagenService imagen) {
        this.cmtService = imagen;
    }

    @GetMapping(path = "/imagen", produces = "application/json; charset=utf-8")
    public List<Imagen> getImagens(String imagen_id) throws ServiceException {
        return cmtService.solicitaImagenes(imagen_id);
    }

    @PostMapping(path = "/imagen", produces = "application/json; charset=utf-8")
    public Integer actualizaImagen(@RequestBody Imagen p) {
        return cmtService.actualizaImagen(p);
    }

    @DeleteMapping(path = "/imagen", produces = "application/json; charset=utf-8")
    public void borraImagen(String cmtId) {
        cmtService.borraImagen(cmtId);
    }

}
