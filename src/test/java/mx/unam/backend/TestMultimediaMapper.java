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

import mx.unam.backend.model.Multimedia;
import mx.unam.backend.mapper.MultimediaMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMultimediaMapper {

    @Mock
    private MultimediaMapper multimediaMap;

    @Autowired
    private MultimediaMapper multimediaMapper;

    private Multimedia multimedia;
    private Multimedia multimediaAux;
    private List<Multimedia> multimediaes;

    @Before
    public void prepara() {
        this.multimedia = new Multimedia(100, 1, 1, "TestMultimedia", true);
        this.multimediaAux = new Multimedia(200, 1, 1, "testing 2", false);
        this.multimediaes = new LinkedList<Multimedia>();
        this.multimediaes.add(multimedia);

    }

    @Test
    public void insertCorrect() throws ServiceException, SQLException {
        int insertaCorrect = multimediaMapper.insertMultimedia(multimedia);
        int insertaCorrecto2 = multimediaMapper.insertMultimedia(multimediaAux);
        Assert.assertEquals(1, insertaCorrect);
    }

    @Test
    public void requestImagenCorrect() throws ServiceException, SQLException {
        Multimedia requestMultimediaCorrecto = multimediaMapper.getByImagenId(200);
        Assert.assertEquals(multimediaAux.getEsVideo(), requestMultimediaCorrecto.getEsVideo());
        Assert.assertEquals(multimediaAux.getMultimediaId(), requestMultimediaCorrecto.getMultimediaId());
        Assert.assertEquals(multimediaAux.getPublicacionId(), requestMultimediaCorrecto.getPublicacionId());
        Assert.assertEquals(multimediaAux.getUsuarioCreador(), requestMultimediaCorrecto.getUsuarioCreador());
    }

    @Test
    public void requestVideoCorrect() throws ServiceException, SQLException {
        Multimedia requestMultimediaCorrecto = multimediaMapper.getByVideoId(100);
        Assert.assertEquals(multimedia.getEsVideo(), requestMultimediaCorrecto.getEsVideo());
        Assert.assertEquals(multimedia.getMultimediaId(), requestMultimediaCorrecto.getMultimediaId());
        Assert.assertEquals(multimedia.getPublicacionId(), requestMultimediaCorrecto.getPublicacionId());
        Assert.assertEquals(multimedia.getUsuarioCreador(), requestMultimediaCorrecto.getUsuarioCreador());
    }

    // @Test
    // public void requestMultimediasCorrect() throws ServiceException, SQLException {
    //     List<Multimedia> requestMultimediasCorrecto = multimediaMapper.getMultimediasPublicacion(1);
    //     Assert.assertEquals(multimediaes, requestMultimediasCorrecto);
    // }

    @Test
    public void deleteMultimediaCorrect() throws ServiceException, SQLException {
        int deleteMultimediaCorrecto = multimediaMapper.deleteMultimedia(167);
        Assert.assertTrue("Multimedia eliminada correctamente o no encontrada", (deleteMultimediaCorrecto == (0) || deleteMultimediaCorrecto == (1)));
    }
}