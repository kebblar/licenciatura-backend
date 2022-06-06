package mx.unam.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mx.unam.backend.model.Comentario;

public class TestComentarioController extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getComentarios() throws Exception {
      String uri = "/feed/comentario?publicacion_id=1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
   }
//    @Test
//    public void createComentario() throws Exception {
//       String uri = "/feed/comentario";
//       Comentario comentario = new Comentario(250, 1, 1, "textoComentario2", "6-6-666");
//       String inputJson = super.mapToJson(comentario);
//       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//         .param("p", inputJson)
//          .contentType(MediaType.APPLICATION_JSON_VALUE)
//          .content(inputJson)).andReturn();
      
//       int status = mvcResult.getResponse().getStatus();
//       assertEquals(200, status);
//    }
   @Test
   public void updateComentario() throws Exception {
      String uri = "/feed/comentario";
      Comentario comentario = new Comentario(0, 1, 1, "UPDATE_TEST", "1999-12-31 23:59:59");
      String inputJson = super.mapToJson(comentario);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
        .param("p", inputJson)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
    //   assertEquals(content, "Comentario is updated successsfully");
   }
   @Test
   public void deleteComentario() throws Exception {
      String uri = "/feed/comentario?cmtId=300";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
      ).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
    //   assertEquals(content, "Comentario is deleted successsfully");
   }
}
