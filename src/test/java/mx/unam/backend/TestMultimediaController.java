package mx.unam.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mx.unam.backend.model.Multimedia;

public class TestMultimediaController extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getMultimedias() throws Exception {
      String uri = "/feed/multimedia?multimedia_id=1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
   }


//    @Test
//    public void getMultimediaById() throws Exception {
//       String uri = "/feed/multimedia/1";
//       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
//       int status = mvcResult.getResponse().getStatus();
//       assertEquals(200, status);
//     //   String content = mvcResult.getResponse().getContentAsString();
//    }
   @Test
   public void createMultimedia() throws Exception {
      String uri = "/feed/multimedia";
      Multimedia multimedia = new Multimedia(3, 1, 1, "textoMultimedia2", true);
      String inputJson = super.mapToJson(multimedia);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
              .param("in", inputJson)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }

   @Test
   public void deleteMultimedia() throws Exception {
      String uri = "/feed/multimedia?cmtId=300";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
      ).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    //   String content = mvcResult.getResponse().getContentAsString();
    //   assertEquals(content, "Multimedia is deleted successsfully");
   }
}
