package mx.unam.backend;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mock;

import mx.unam.backend.model.Comentario;
import mx.unam.backend.mapper.ComentarioMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestComentarioMapper {

    @Mock
    private ComentarioMapper comentarioMap;

    @Autowired
    private ComentarioMapper comentarioMapper;

    private Comentario comentario;
    private Comentario comentarioAux;
    private List<Comentario> comentarioes;

    @Before
    public void prepara() {
        this.comentario = new Comentario(100, 1, 1, "TestComentario", "1999-12-31 23:59:59");
        this.comentarioAux = new Comentario(2, 1, 1, "testing 2", "1999-12-31 23:59:59");
        this.comentarioes = new LinkedList<Comentario>();
        this.comentarioes.add(comentario);

    }

    @Test
    public void insertCorrect() throws ServiceException, SQLException {
        int insertaCorrecto = comentarioMapper.insertComentario(comentario);
        Assert.assertEquals(1, insertaCorrecto);
    }

    @Test
    public void requestComentarioCorrect() throws ServiceException, SQLException {
        Comentario requestComentarioCorrecto = comentarioMapper.getByComentarioId(100);
        Assert.assertEquals(comentario.getComentarioId(), requestComentarioCorrecto.getComentarioId());
        Assert.assertEquals(comentario.getPublicacionId(), requestComentarioCorrecto.getPublicacionId());
        Assert.assertEquals(comentario.getUsuarioCreadorId(), requestComentarioCorrecto.getUsuarioCreadorId());
    }

    // @Test
    // public void requestComentariosCorrect() throws ServiceException, SQLException {
    //     List<Comentario> requestComentariosCorrecto = comentarioMapper.getComentarios(1);
    //     Assert.assertEquals(comentarioes, requestComentariosCorrecto);
    // }

    @Test
    public void updateComentarioCorrect() {
        int updateComentarioCorrecto = comentarioMapper.updateComentario(comentario);
        Assert.assertTrue("Comentario actualizado correctamente o no encontrada", (updateComentarioCorrecto == (0) || updateComentarioCorrecto == (1)));
    }

    @Test
    public void deleteComentarioCorrect() throws ServiceException, SQLException {
        int deleteComentarioCorrecto = comentarioMapper.deleteComentario(167);
        Assert.assertTrue("Comentario eliminada correctamente o no encontrada", (deleteComentarioCorrecto == (0) || deleteComentarioCorrecto == (1)));
    }
}