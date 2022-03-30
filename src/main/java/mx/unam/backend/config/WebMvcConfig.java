package mx.unam.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /** {@inheritDoc} */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**/

        registry
            .addMapping("/**")
            .allowedOrigins("http://127.0.0.1","http://localhost")
            .allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS", "HEAD");
        /**/
    }

}