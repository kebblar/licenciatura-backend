package unam.mx.backend.rest;

import unam.mx.backend.exceptions.ControllerException;
import unam.mx.backend.model.CredencialesRequest;
import unam.mx.backend.model.Login;
import unam.mx.backend.service.LoginService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/administrador")
public class AccessController {
    private final LoginService loginService;

    public AccessController(LoginService administradorService){
        this.loginService = administradorService;
    }

    @ApiOperation(
            value = "AdministradorController::info",
            notes = "Recibe el usuario con el que queremos iniciar sesion.")
    @PostMapping(
        path = "/login",
        produces = "application/json; charset=utf-8")
    public Login login(@ApiParam(
        name = "administrador",
        value = "Representa a un usuario (mail, password)")
        @RequestBody CredencialesRequest usuario) throws ControllerException{
        return loginService.login(usuario); 
    }
}
