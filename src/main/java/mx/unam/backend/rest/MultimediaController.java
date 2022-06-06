package mx.unam.backend.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.model.Multimedia;
import mx.unam.backend.service.MultimediaService;

/**
 * Implementacion del Controller de la entidad de 'Multimedia'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")
public class MultimediaController {

    private MultimediaService cmtService;

    public MultimediaController(MultimediaService multimedia) {
        this.cmtService = multimedia;
    }

    @GetMapping(path = "/multimedia", produces = "application/json; charset=utf-8")
    public List<Multimedia> getMultimedias(int multimedia_id) throws ServiceException {
        return cmtService.solicitaMultimedias(multimedia_id);
    }

    @GetMapping(path = "/multimedia/{id}", produces = "application/json; charset=utf-8")
    public Multimedia getMultimediabyId(Integer multimedia_id) throws ServiceException {
        return cmtService.solicitarImagen(multimedia_id);
    }

    @PostMapping(path = "/multimedia", produces = "application/json; charset=utf-8")
    public Integer creaMultimedia(@RequestBody Multimedia in) throws SQLException {
        return cmtService.creaMultimedia(in);
    }

    @DeleteMapping(path = "/multimedia", produces = "application/json; charset=utf-8")
    public Integer borraMultimedia(int cmtId) {
        return cmtService.borraMultimedia(cmtId);
    }

}
