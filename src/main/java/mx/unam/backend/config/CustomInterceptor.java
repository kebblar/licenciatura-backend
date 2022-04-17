
/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.config
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CustomInterceptor
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:02:16
 */
package mx.unam.backend.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import mx.unam.backend.utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The {@code String} class represents character strings. All
 * string literals in Java programs, such as {@code "abc"}, are
 * implemented as instances of this class.
 *
 * <p>Strings are constant; their values cannot be changed after they
 * Because String objects are immutable they can be shared.</p>
 *
 * <p>For example:</p>
 * <blockquote><pre>
 *     String str = "abc";
 * </pre></blockquote>
 * is equivalent to:
 * <blockquote><pre>
 *     char data[] = {'a', 'b', 'c'};
 *     String str = new String(data);
 * </pre></blockquote>
 * <p>Here are some more examples of how strings can be used:</p>
 * <blockquote><pre>
 *     System.out.println("abc");
 *     String cde = "cde";
 *     System.out.println("abc" + cde);
 *     String c = "abc".substring(2,3);
 *     String d = cde.substring(1, 2);
 * </pre></blockquote>
 *
 * <p>The class {@code String} includes methods for examining
 * lowercase. Case mapping is based on the Unicode Standard version
 * specified by the {@link java.lang.Character Character} class.</p>
 *
 * @author  garellano
 * @see     java.lang.Object#toString()
 * @since   0.0.1-SNAPSHOT
 * @version $Id: $Id
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {

    /*
     * Atributos logger y jwt.
     */
    private final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
    private String encryptKey;

    /**
     * Constructor que recibe el jwtoken para validar los tokens que vienen en el header.
     * Esto facilita su posterior procesamiento
     *
     * @param jwtToken jwt token a asignar
     */
    public CustomInterceptor(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    /** {@inheritDoc} */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Enumeration<String> headerNames = request.getHeaderNames();
        String remoteAddress = request.getRemoteAddr();
        
        if (uri.startsWith("/api/")) {
            ArrayList<String> lista = Collections.list(headerNames);
            for (String headerName : lista) {
                // for unit testing, we will have to mock the HttpServletRequest
                String headerValue = request.getHeader(headerName);
                if (headerName.contains("jwt") && headerValue != null && headerValue.trim().length() > 0) {
                    logger.info("App caller IP detected:: {}", remoteAddress);
                    logger.info("App current uri detected:: {}", uri);
                    logger.info("El header {} tiene el valor: {}", headerName, headerValue);
                    String jwtToken = headerValue;
                    try {
                        // valida firma y expiración
                        JWTUtil.getInstance().revisaToken(jwtToken, encryptKey);
                    } catch (Exception e) {
                        // also, for UT, we need to mock HttpServletResponse
                        construye(response, e.getMessage(), jwtToken);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Método que se encarga de construir la respuesta mostrando el código http y el mensaje.
     *
     * @param response código de error Http
     * @param message corresponde al texto que explica la situación
     */
    private void construye(HttpServletResponse response, String message, String token) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("exceptionTypeNumber", 1090);
        map.put("exceptionTypeKey", "EX_1090");
        map.put("exceptionLongDescription", message + " (" + token + ")");
        map.put("exceptionShortDescription", "Invalid Token");
        map.put("httpResponse",  HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write(mapper.writeValueAsString(map));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}