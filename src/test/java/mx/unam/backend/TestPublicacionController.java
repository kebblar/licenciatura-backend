package mx.unam.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mx.unam.backend.model.Publicacion;

public class TestPublicacionController extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getPublicacions() throws Exception {
      String uri = "/feed/publicacion/publicacion_id?publicacion_id=1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
   }
//    @Test
//    public void createPublicacion() throws Exception {
//       String uri = "/feed/publicacion";
//       Publicacion publicacion = new Publicacion(300, 1, "fecha2", "textoPubli2", false);
//       String inputJson = super.mapToJson(publicacion);
//       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//         .param("p", inputJson)
//          .contentType(MediaType.APPLICATION_JSON_VALUE)
//          .content(inputJson)).andReturn();
      
//       int status = mvcResult.getResponse().getStatus();
//       assertEquals(200, status);
//    }
   @Test
   public void updatePublicacion() throws Exception {
      String uri = "/feed/publicacion";
      Publicacion publicacion = new Publicacion(0, 1, "1999-12-31 23:59:59", "UPDATE_TEST", false);
      String inputJson = super.mapToJson(publicacion);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
        .param("p", inputJson)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
    //   assertEquals(content, "Publicacion is updated successsfully");
   }
   @Test
   public void deletePublicacion() throws Exception {
      String uri = "/feed/publicacion/publicacion_id?publicacion_id=300";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
      ).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
    //   assertEquals(content, "Publicacion is deleted successsfully");
   }
}
