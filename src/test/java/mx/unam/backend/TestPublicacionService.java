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
import mx.unam.backend.service.PublicacionService;
import mx.unam.backend.service.PublicacionServiceImpl;
import mx.unam.backend.mapper.PublicacionMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPublicacionService {

    @Mock
    private PublicacionMapper publicacionMapper;

    @Autowired
    private PublicacionService publicacionService;

    private Publicacion publicacion;
    private Publicacion publicacionAux;
    private List<Publicacion> publicaciones;

    @Before
    public void prepara() {
        this.publicacion = new Publicacion(1, 1, "27-12-12", "testing", true);
        this.publicacionAux = new Publicacion(2, 1, "29-10-10", "testing 2", true);
        this.publicaciones = new LinkedList<Publicacion>();
        this.publicaciones.add(publicacion);
        this.publicacionService = new PublicacionServiceImpl(publicacionMapper);

    }

    @Test
    public void insertCorrect() throws ServiceException, SQLException {
        try {
            Mockito.when(publicacionService.inserta(publicacion)).thenReturn(1);
            int insertaCorrecto = publicacionService.inserta(publicacion);
            Assert.assertEquals(1, insertaCorrecto);
        } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void requestPublicationCorrect() throws ServiceException, SQLException {
        try {
            Mockito.when(publicacionMapper.getByPublicacionId(0)).thenReturn(publicacion);
            Publicacion requestPublicationCorrecto = publicacionService.solicitarPublicacion(0);
            Assert.assertEquals(publicacion, requestPublicationCorrecto);
        } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void requestPublicationsCorrect() throws ServiceException, SQLException {
        try {
            Mockito.when(publicacionMapper.getPublicaciones(0)).thenReturn(publicaciones);
            List<Publicacion> requestPublicationsCorrecto = publicacionService.solicitaPublicacions(0);
            Assert.assertEquals(publicaciones, requestPublicationsCorrecto);
        } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void updatePublicationCorrect() {
        Mockito.when(publicacionMapper.updatePublicacion(publicacion)).thenReturn(1);
        int updatePublicationCorrecto = publicacionService.actualizaPublicacion(publicacion);
        Assert.assertEquals(1, updatePublicationCorrecto);
    }

    @Test
    public void deletePublicationCorrect() throws ServiceException, SQLException {
        Mockito.when(publicacionMapper.deletePublicacion(0)).thenReturn(1);
        int deletePublicationCorrecto = publicacionService.borraPublicacion(0);
        Assert.assertEquals(1, deletePublicationCorrecto);
    }
}