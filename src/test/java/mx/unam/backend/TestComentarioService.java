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
import mx.unam.backend.service.ComentarioService;
import mx.unam.backend.model.UsuarioDetalle;
import mx.unam.backend.service.ComentarioServiceImpl;
import mx.unam.backend.mapper.ComentarioMapper;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.exceptions.ControllerException;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestComentarioService {

    @Mock
    private ComentarioMapper comentarioMapper;
    
   @Autowired
   private ComentarioService comentarioService;

   private Comentario comentario;
   private Comentario comentarioAux;
   private List<Comentario> comentarioes;

   @Before
   public void prepara(){
    this.comentario = new Comentario(1, 1, 1,"testing", "22-13-12");
    this.comentarioAux = new Comentario(2, 1, 1,"testing 2", "10-10-10");
    this.comentarioes = new LinkedList<Comentario>();
    this.comentarioes.add(comentario);
    this.comentarioService = new ComentarioServiceImpl(comentarioMapper);
    
}

   @Test
   public void insertCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(comentarioService.inserta(comentario)).thenReturn(1);
        int insertaCorrecto = comentarioService.inserta(comentario);
        Assert.assertEquals(1, insertaCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void requestComentarioCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(comentarioMapper.getByComentarioId(0)).thenReturn(comentario);
        Comentario requestComentarioCorrecto = comentarioService.solicitarComentario(0);
        Assert.assertEquals(comentario, requestComentarioCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void requestComentariosCorrect() throws ServiceException, SQLException{
    try {
        Mockito.when(comentarioMapper.getComentarios(0)).thenReturn(comentarioes);
        List<Comentario> requestComentariosCorrecto = comentarioService.solicitaComentarios(0);
        Assert.assertEquals(comentarioes, requestComentariosCorrecto);    
    } catch (ControllerException e) {
            Assert.assertFalse(true);
        }
   }

   @Test
   public void updateComentarioCorrect() {
    Mockito.when(comentarioMapper.updateComentario(comentario)).thenReturn(1);
    int updateComentarioCorrecto = comentarioService.actualizaComentario(comentario);
    Assert.assertEquals(1, updateComentarioCorrecto);
   }

   @Test
   public void deleteComentarioCorrect() throws ServiceException, SQLException{
    Mockito.when(comentarioMapper.deleteComentario(0)).thenReturn(1);
    int deleteComentarioCorrecto = comentarioService.borraComentario(0);
    Assert.assertEquals(1, deleteComentarioCorrecto);
   }
}