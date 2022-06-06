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
import mx.unam.backend.model.Comentario;
import mx.unam.backend.service.ComentarioService;

/**
 * Implementacion del Controller de la entidad de 'Comentario'.
 *
 * @author Gerardo García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/feed")

public class ComentarioController {
/**
 * Constructor que realiza el setting de los servicios que seran
 * utilizados en este controlador.
 *
 * @param usuarioService Servicios de AccessService
 */
	private ComentarioService cmtService;
	
	public ComentarioController(ComentarioService comentario) {
		this.cmtService = comentario;
	}

	@GetMapping(path = "/comentario", produces = "application/json; charset=utf-8")
	public List<Comentario> getComentarios(Integer publicacion_id) throws ServiceException {
		return cmtService.solicitaComentarios(publicacion_id);
	}

	@PutMapping(path = "/comentario", produces = "application/json; charset=utf-8")
	public Integer actualizaComentario(@RequestBody Comentario p) {
		return cmtService.actualizaComentario(p);
	}

	@PostMapping(path = "/comentario", produces = "application/json; charset=utf-8")
	public Integer creaComentario(@RequestBody Comentario p) throws ServiceException, SQLException {
		return cmtService.inserta(p);
	}

	@DeleteMapping(path = "/comentario", produces = "application/json; charset=utf-8")
	public Integer borraComentario(Integer cmtId) {
		return cmtService.borraComentario(cmtId);
	}

}
