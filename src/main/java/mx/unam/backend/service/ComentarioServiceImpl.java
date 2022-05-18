package mx.unam.backend.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.ComentarioMapper;
import mx.unam.backend.model.Comentario;

/**
 * <p>
 * Implementación de la interfaz {@link mx.unam.backend.service.UsuarioService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan
 * {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author garellano, mentesniker
 * @see unam.mx.backend.domain.Usuario
 * @see mx.unam.backend.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Service
public class ComentarioServiceImpl implements ComentarioService {

    private ComentarioMapper cmt;

    public ComentarioServiceImpl(ComentarioMapper cmt) {
        this.cmt = cmt;
    }

    @Override
    public Comentario solicitarComentario(int comentarioId) {
        return cmt.getByComentarioId(comentarioId);
    }

    @Override
    public Integer inserta(Comentario in) throws SQLException {
        return cmt.insertComentario(in);
    }

    @Override
    public List<Comentario> solicitaComentarios(int publicacion_id) throws ServiceException {
        return cmt.getComentarios(publicacion_id);
    }

    @Override
    public Integer actualizaComentario(Comentario in) {
        return cmt.updateComentario(in);
    }

    @Override
    public void borraComentario(int cmtId) {
        cmt.deleteComentario(cmtId);
    }

}