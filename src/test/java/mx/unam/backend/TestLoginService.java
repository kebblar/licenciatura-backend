package mx.unam.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.service.LoginService;
import mx.unam.backend.service.LoginServiceImpl;
import mx.unam.backend.utils.EnumMessage;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestLoginService {
    private LoginService loginService;

    private boolean checa(ControllerException e, EnumMessage m) {
    	return m.toString().equals(e.getLocalExceptionKey());    	
    }

    @Mock
    private UsuarioMapper usuarioMapper;

    @Test
    public void loginTest() {
        Usuario usuario = new Usuario(1, "goose@mail.com", "42a83c6132a2f3801191edec975f7f0f802fdfb373f9c3378043c93dbab70fd4",
        0, false, 0, 0, 0);
        usuario.setActivo(true);
        this.loginService = new LoginServiceImpl(usuarioMapper);
        when(usuarioMapper.getbyMail("goose@mail.com")).thenReturn(usuario);
        CredencialesRequest credenciales = new CredencialesRequest();
        
        // successful login
        try {
            credenciales.setMail("goose@mail.com");
            credenciales.setClave("garellano");
            this.loginService.login(credenciales);
            assertTrue(true);
        } catch (ControllerException e) {
            assertTrue(false);
        }
        
        // bad password, try #2
        try {
            credenciales.setMail("goose@mail.com");
            credenciales.setClave("garellanos");
            this.loginService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.BAD_CREDENTIALS));
        }
        
        // bad password, try #5
        try {
            usuario.setAccesoNegadoContador(5);
            this.loginService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.MAX_FAILED_LOGIN_EXCEPTION));
        }
        
        // good password, still bloqued
        try {
            credenciales.setMail("goose@mail.com");
            credenciales.setClave("garellanos");
            usuario.setAccesoNegadoContador(1);
            usuario.setInstanteBloqueo(System.currentTimeMillis());
            this.loginService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.WAIT_LOGIN));
        }
        
        // uses doesn't exist
        try {
            credenciales.setMail("g@mail.com");
            this.loginService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.BAD_CREDENTIALS));
        }  
        
        // user disabled, no matter what
        try {
            credenciales.setMail("goose@mail.com");
            usuario.setAccesoNegadoContador(0);
            usuario.setActivo(false);
            this.loginService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.DISABLED_USER));
        }        
        
    }
}
