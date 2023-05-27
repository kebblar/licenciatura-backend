package mx.unam.backend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadException {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> maxException(MaxUploadSizeExceededException musee) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El archivo es demasiado grande");
    }
}
