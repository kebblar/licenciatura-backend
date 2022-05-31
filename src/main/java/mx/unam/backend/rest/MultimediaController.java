package mx.unam.backend.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(path = "/multimedia", produces = "application/json; charset=utf-8")
    public void creaMultimedia(@RequestBody Multimedia p, @RequestParam("multimedia") List<MultipartFile> in)
            throws IOException, SQLException {
        for (MultipartFile m : in) {
            String ruta = StringUtils.cleanPath(m.getOriginalFilename());
            p.setMultimedia(ruta);
            // FileUploadUtil.saveFile("/", ruta, p);
            cmtService.creaMultimedia(p);
        }
    }

    @DeleteMapping(path = "/multimedia", produces = "application/json; charset=utf-8")
    public void borraMultimedia(int cmtId) {
        cmtService.borraMultimedia(cmtId);
    }

}
