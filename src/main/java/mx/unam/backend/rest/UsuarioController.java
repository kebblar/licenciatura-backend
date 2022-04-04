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
package mx.unam.backend.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Login;
import mx.unam.backend.model.Preregistro;
import mx.unam.backend.model.RecuperacionTokenRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.service.UsuarioService;

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
 * @see     mx.unam.backend.model.CredencialesRequest
 * @see     mx.unam.backend.model.RecuperacionTokenRequest
 * @see     mx.unam.backend.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

     /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param usuarioService Servicios de AccessService
     */
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @ApiOperation(
            value = "UsuarioController::login",
            notes = "Recibe el usuario con el que queremos iniciar sesion.")
    @PostMapping(
        path = "/login",
        produces = "application/json; charset=utf-8")
    public Login login(@ApiParam(
        name = "usuario",
        value = "Representa a un usuario (mail, password)")
        @RequestBody CredencialesRequest usuario) throws ControllerException{
        return usuarioService.login(usuario); 
    }

    @ApiOperation(
            value = "UsuarioController::recuperarClave",
            notes = "Recibe el mail del usuario del que queremos recuperar su contrasena.")
    @PostMapping(
        path = "/recupera-clave",
        produces = "application/json; charset=utf-8")
    public Usuario recuperarClave(@ApiParam(
        name = "mail",
        value = "Contiene el correo del usuario")
        @RequestBody String mail) throws ControllerException{
        return usuarioService.solicitaRegeneracionClave(mail); 
    }

    @ApiOperation(
            value = "UsuarioController::confirmaRegeneracionClave",
            notes = "Recibe la nueva clave y el token del usuario del que queremos recuperar su contrasena.")
    @PostMapping(
        path = "/confirma-token",
        produces = "application/json; charset=utf-8")
    public Usuario confirmaRegeneraClave(@ApiParam(
        name = "clave nueva y Token",
        value = "Representa a una confirmacion de regeneracion (mail, nueva clave y token)")
        @RequestBody RecuperacionTokenRequest tokenRequest) throws ControllerException{
        return usuarioService.confirmaRegeneraClave(tokenRequest); 
    }

    @ApiOperation(
            value = "UsuarioController::preRegistro",
            notes = "Recibe la informacion del usuario necesaria para su registro")
    @PostMapping(
        path = "/preregistro",
        produces = "application/json; charset=utf-8")
    public Preregistro preRegistro(@ApiParam(
        name = "preregistro",
        value = "Contiene la informacion que un usuario necesita para hacer un preregistro.")
        @RequestBody Preregistro preregistro) throws ControllerException{
        return usuarioService.preRegistro(preregistro); 
    }

    @ApiOperation(
            value = "UsuarioController::preRegistro",
            notes = "Recibe el token enviado al correo electronico del usuario")
    @PostMapping(
        path = "/confirma-registro",
        produces = "application/json; charset=utf-8")
    public Usuario confirmaPreregistro(@ApiParam(
        name = "token",
        value = "Contiene el token de confirmacion.")
        @RequestBody String token) throws ControllerException{
        return usuarioService.confirmaPreregistro(token); 
    }
}