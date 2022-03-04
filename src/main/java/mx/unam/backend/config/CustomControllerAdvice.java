package mx.unam.backend.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.backend.exceptions.ControllerException;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador que manejara las excepciones lanzadas por los demas
 * controladores.
 *
 * @author goose
 * @version 1.0
 */
@ControllerAdvice
public class CustomControllerAdvice {

    /**
     * Método que maneja las exepciones de {@link io.kebblar.petstore.api.model.exceptions.ControllerException}.
     *
     * @param geEx la excepción que manejará (de tipo ControllerException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(ControllerException geEx) {
        int value = geEx.getHttpEstado().value();
        return new ResponseEntity<>(crearMapaRetorno(geEx), HttpStatus.valueOf(value));
    }

    /**
     * Método auxiliar que crea el objeto a mostrarse cuando se lance la excepcion.
     *
     * @param ex la excepcion a mapear
     * @return el diccionario con la excepcion mapeada
     */
    private Map<String, Object> crearMapaRetorno(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof ControllerException) {
            ControllerException ad = (ControllerException) (ex);
            map.put("Numero de exepcion", ad.getLocalExceptionNumber());
            map.put("Accion", ad.getDetailedMessage());
            map.put("Descripcion", ad.getShortMessage());
            map.put("httpResponse",  ad.getHttpEstado());
        }
        return map;
    }
}