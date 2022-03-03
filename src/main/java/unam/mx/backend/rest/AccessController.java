/*
 *
 * Paquete:     unam.mx.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      AccessController
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 02 Mar 2022
 */
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

/**
 * Implementacion  del controlador REST asociado a los endpoints
 * de gestión del AccessController.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}</p>
 *
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 *
 * @author  mentesniker
 * @see     unam.mx.backend.model.CredencialesRequest
 * @see     unam.mx.backend.service.LoginService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/administrador")
public class AccessController {
    private final LoginService loginService;

     /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param accessService Servicios de AccessService
     */
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
