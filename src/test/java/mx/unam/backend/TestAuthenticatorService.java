package mx.unam.backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.Rol;
import mx.unam.backend.utils.AuthenticatorService;
import mx.unam.backend.utils.AuthenticatorServiceImpl;
import mx.unam.backend.utils.JWTUtil;

@MapperScan("mx.unam.backend.mapper")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestAuthenticatorService {
    @Mock
    private UsuarioMapper usuarioMapper;

    private AuthenticatorService auth;

    @Test
    public void authenticaTest(){
        auth = new AuthenticatorServiceImpl(usuarioMapper);
        String jwt = JWTUtil.getInstance().createToken("goose@mail.com",
         27, null);
        LinkedList<Rol> roles = new LinkedList<Rol>();
        roles.add(new Rol(1, "USUARIO", true));
        when(usuarioMapper.getRoles("goose@mail.com")).thenReturn(roles);

        try{
            auth.authentica("USUARIO", jwt);
            assertTrue(true);
        }
        catch(Exception e){
            assertFalse(true);
        }
        try{
            auth.authentica("ADMINISTRADOR", jwt);
            assertTrue(false);
        }
        catch(ServiceException e){
            assertTrue(true);
        }

    }

}
