package unam.mx.backend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clase")
public class SaludaController {
    
    @GetMapping(
        path = "/nombre/{tuNombre}",
        produces = "application/json; charset=utf-8"
    )
    public String saluda(@PathVariable String tuNombre){
        return "{'Saluda': 'Hola #nombre'}".replace("#nombre", tuNombre);
    }

}
