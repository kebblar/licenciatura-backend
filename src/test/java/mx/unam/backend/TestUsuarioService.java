package mx.unam.backend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import mx.unam.backend.exceptions.ControllerException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.CredencialesRequest;
import mx.unam.backend.model.RecuperacionTokenRequest;
import mx.unam.backend.model.Usuario;
import mx.unam.backend.service.MailSenderService;
import mx.unam.backend.service.UsuarioService;
import mx.unam.backend.service.UsuarioServiceImpl;
import mx.unam.backend.utils.EnumMessage;

@MapperScan("mx.unam.backend.mapper")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestUsuarioService {

    @Mock
    private UsuarioMapper usuarioMapper;

    @Mock 
    private MailSenderService mailSenderService;

    private UsuarioService usuarioService;

    private Usuario usuario;

    private boolean checa(ControllerException e, EnumMessage m) {
    	return m.toString().equals(e.getLocalExceptionKey());    	
    }

    @Before
    public void prepara(){
        this.usuario = new Usuario(1, "goose@mail.com", "42a83c6132a2f3801191edec975f7f0f802fdfb373f9c3378043c93dbab70fd4",
        0, false, 0, 0, 0, 0, "aaa", 0);
        usuario.setActivo(true);
        this.usuarioService = new UsuarioServiceImpl(usuarioMapper,mailSenderService);
    }

    @Test
    public void testSolicitaRegeneracionClave() throws ServiceException {
        when(usuarioMapper.getByMail(Mockito.any(String.class))).thenReturn(null);
        assertEquals("", usuarioService.solicitaRegeneracionClave("correo@correo.com").getMail());
        
        when(usuarioMapper.getByMail(Mockito.any(String.class))).thenReturn(usuario);
        assertEquals("goose@mail.com", usuarioService.solicitaRegeneracionClave("goose@mail.com").getMail());
    }

    @Test
    public void testConfirmaRegeneraClave() throws ServiceException{
        RecuperacionTokenRequest recuperacionToken = new RecuperacionTokenRequest("xxx", "hola", "correo@correo.com");

        //Menos de 8 caracteres
        try {
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 

        //con espacios
        try {
            recuperacionToken.setClaveNueva("h olaaaa");
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 

        //sin mayusculas
        try {
            recuperacionToken.setClaveNueva("holaaaaa");
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 

        //sin minusculas
        try {
            recuperacionToken.setClaveNueva("HOLAAAAA");
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 

        //sin numeros
        try {
            recuperacionToken.setClaveNueva("Holaaaaa");
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 

        //sin caracteres especiales
        try {
            recuperacionToken.setClaveNueva("Hola1234");
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.STRENGTH_PASSWORD_VALIDATOR));
        } 
        
        //correo equivocado
        try {
            recuperacionToken.setClaveNueva("Hola1234#");
            when(usuarioMapper.getByMail("correo@correo.com")).thenReturn(null);
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.TOKEN_NOT_EXIST));
        }
        
        //token no existente
        try {
            recuperacionToken.setMail("goose@mail.com");
            when(usuarioMapper.getByMail("goose@mail.com")).thenReturn(usuario);
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.TOKEN_NOT_EXIST));
        }
        
        //token expirado
        try {
            recuperacionToken.setMail("goose@mail.com");
            recuperacionToken.setToken("aaa");
            when(usuarioMapper.getByMail("goose@mail.com")).thenReturn(usuario);
            usuario.setRegeneraClaveInstante(System.currentTimeMillis() - (60000 * 80L));
            usuarioService.confirmaRegeneraClave(recuperacionToken);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.TOKEN_EXPIRED));
        }

        //todo ok
        try {
            
            when(usuarioMapper.getByMail("goose@mail.com")).thenReturn(usuario);
            usuario.setRegeneraClaveInstante(System.currentTimeMillis()-60000);
            assertEquals(usuario, usuarioService.confirmaRegeneraClave(recuperacionToken));
        } catch (ControllerException e) {
            assertFalse(true);
        }
    }

    @Test
    public void loginTest() {
        when(usuarioMapper.getByMail("goose@mail.com")).thenReturn(usuario);
        CredencialesRequest credenciales = new CredencialesRequest();
        
        // successful login
        try {
            credenciales.setMail("goose@mail.com");
            credenciales.setClave("garellano");
            this.usuarioService.login(credenciales);
            assertTrue(true);
        } catch (ControllerException e) {
            assertTrue(false);
        }
        
        // bad password, try #2
        try {
            credenciales.setMail("goose@mail.com");
            credenciales.setClave("garellanos");
            this.usuarioService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.BAD_CREDENTIALS));
        }
        
        // bad password, try #5
        try {
            usuario.setAccesoNegadoContador(5);
            this.usuarioService.login(credenciales);
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
            this.usuarioService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.WAIT_LOGIN));
        }
        
        // user doesn't exist
        try {
            credenciales.setMail("g@mail.com");
            this.usuarioService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.BAD_CREDENTIALS));
        }  
        
        // user disabled, no matter what
        try {
            credenciales.setMail("goose@mail.com");
            usuario.setAccesoNegadoContador(0);
            usuario.setActivo(false);
            this.usuarioService.login(credenciales);
            assertTrue(false);
        } catch (ControllerException e) {
            assertTrue(checa(e, EnumMessage.DISABLED_USER));
        }        
        
    }
}
