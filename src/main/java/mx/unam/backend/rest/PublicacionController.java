package mx.unam.backend.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Publicacion;
import mx.unam.backend.service.PublicacionService;

/**
 * Implementacion del Controller de la entidad de 'Publicacion'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class PublicacionController {

    private PublicacionService cmtService;

    public PublicacionController(PublicacionService publicacion) {
        this.cmtService = publicacion;
    }

    @GetMapping(path = "/publicacion", produces = "application/json; charset=utf-8")
    public List<Publicacion> getPublicacions(String publicacion_id) throws ServiceException {
        return cmtService.solicitaPublicacions(publicacion_id);
    }

    @PostMapping(path = "/publicacion", produces = "application/json; charset=utf-8")
    public Integer actualizaPublicacion(@RequestBody Publicacion p) {
        return cmtService.actualizaPublicacion(p);
    }

    @PutMapping(path = "/publicacion", produces = "application/json; charset=utf-8")
    public Integer creaPublicacion(@RequestBody Publicacion p) throws ServiceException, SQLException {
        return cmtService.inserta(p);
    }

    @DeleteMapping(path = "/publicacion", produces = "application/json; charset=utf-8")
    public void borraPublicacion(String cmtId) {
        cmtService.borraPublicacion(cmtId);
    }

}
