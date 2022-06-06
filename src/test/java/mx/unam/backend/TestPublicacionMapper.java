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

import mx.unam.backend.model.Publicacion;
import mx.unam.backend.mapper.PublicacionMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPublicacionMapper {

    @Mock
    private PublicacionMapper publicacionMap;

    @Autowired
    private PublicacionMapper publicacionMapper;

    private Publicacion publicacion;
    private Publicacion publicacionAux;
    private List<Publicacion> publicaciones;

    @Before
    public void prepara() {
        this.publicacion = new Publicacion(100, 1, "27-12-12", "TestPublication", true);
        this.publicacionAux = new Publicacion(2, 1, "29-10-10", "testing 2", true);
        this.publicaciones = new LinkedList<Publicacion>();
        this.publicaciones.add(publicacion);

    }

    @Test
    public void insertCorrect() throws ServiceException, SQLException {
        int insertaCorrecto = publicacionMapper.insertPublicacion(publicacion);
        Assert.assertEquals(1, insertaCorrecto);
    }

    @Test
    public void requestPublicationCorrect() throws ServiceException, SQLException {
        Publicacion requestPublicationCorrecto = publicacionMapper.getByPublicacionId(100);
        Assert.assertEquals(publicacion.getTextoPlano(), requestPublicationCorrecto.getTextoPlano());
        Assert.assertEquals(publicacion.getFechaCreacion(), requestPublicationCorrecto.getFechaCreacion());
        Assert.assertEquals(publicacion.getEsPublica(), requestPublicationCorrecto.getEsPublica());
        Assert.assertEquals(publicacion.getId(), requestPublicationCorrecto.getId());
        Assert.assertEquals(publicacion.getUsuarioId(), requestPublicationCorrecto.getUsuarioId());
    }

    // @Test
    // public void requestPublicationsCorrect() throws ServiceException, SQLException {
    //     List<Publicacion> requestPublicationsCorrecto = publicacionMapper.getPublicaciones(1);
    //     Assert.assertEquals(publicaciones, requestPublicationsCorrecto);
    // }

    @Test
    public void updatePublicationCorrect() {
        int updatePublicationCorrecto = publicacionMapper.updatePublicacion(publicacion);
        Assert.assertEquals(1, updatePublicationCorrecto);
    }

    @Test
    public void deletePublicationCorrect() throws ServiceException, SQLException {
        int deletePublicationCorrecto = publicacionMapper.deletePublicacion(167);
        Assert.assertTrue("Publicacion eliminada correctamente o no encontrada", (deletePublicationCorrecto == (0) || deletePublicationCorrecto == (1)));
    }
}