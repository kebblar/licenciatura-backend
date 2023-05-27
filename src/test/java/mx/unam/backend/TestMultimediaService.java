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
import mx.unam.backend.service.MultimediaService;
import mx.unam.backend.model.UsuarioDetalle;
import mx.unam.backend.service.MultimediaServiceImpl;
import mx.unam.backend.mapper.MultimediaMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMultimediaService {

    @Mock
    private MultimediaMapper multimediaMapper;
    
   @Autowired
   private MultimediaService multimediaService;

   private Multimedia multimedia;
   private Multimedia multimediaAux;
   private List<Multimedia> multimediaes;

   @Before
   public void prepara(){
    this.multimedia = new Multimedia(1, 1, 1,"testing", true);
    this.multimediaAux = new Multimedia(2, 1, 1,"testing 2", false);
    this.multimediaes = new LinkedList<Multimedia>();
    this.multimediaes.add(multimedia);
    this.multimediaService = new MultimediaServiceImpl(multimediaMapper);
    
}

   @Test
   public void insertCorrect() throws ServiceException, SQLException{
    Mockito.when(multimediaService.creaMultimedia(multimedia)).thenReturn(1);
    int insertaCorrecto = multimediaService.creaMultimedia(multimedia);
    Assert.assertEquals(1, insertaCorrecto);
   }

   @Test
   public void requestImagenCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(multimediaMapper.getByImagenId(0)).thenReturn(multimediaAux);
        Multimedia requestImagenCorrecto = multimediaService.solicitarImagen(0);
        Assert.assertEquals(multimediaAux, requestImagenCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void requestVideoCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(multimediaMapper.getByVideoId(0)).thenReturn(multimedia);
        Multimedia requestImagenCorrecto = multimediaService.solicitarVideo(0);
        Assert.assertEquals(multimedia, requestImagenCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void requestMultimediasCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(multimediaMapper.getMultimediasPublicacion(0)).thenReturn(multimediaes);
        List<Multimedia> requestMultimediasCorrecto = multimediaService.solicitaMultimedias(0);
        Assert.assertEquals(multimediaes, requestMultimediasCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void updateMultimediaCorrect() {
    Mockito.when(multimediaMapper.updateMultimedia(multimedia)).thenReturn(1);
    int updateMultimediaCorrecto = multimediaService.actualizaMultimedia(multimedia);
    Assert.assertEquals(1, updateMultimediaCorrecto);
   }

   @Test
   public void deleteMultimediaCorrect() throws ServiceException, SQLException{
    Mockito.when(multimediaMapper.deleteMultimedia(0)).thenReturn(1);
    int deleteMultimediaCorrecto = multimediaService.borraMultimedia(0);
    Assert.assertEquals(1, deleteMultimediaCorrecto);
   }
}