package mx.unam.backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import  mx.unam.backend.service.HelloWorldClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

  @Autowired
  private HelloWorldClient helloWorldClient;

  @Test
  public void testSayHello() {
    assertThat(helloWorldClient.sayHello("John", "Doe"))
        .isEqualTo("Hello John Doe!");
  }
}