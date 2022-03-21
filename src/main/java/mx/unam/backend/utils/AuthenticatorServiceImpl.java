package mx.unam.backend.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.Rol;

@Service
public class AuthenticatorServiceImpl implements AuthenticatorService{
    private UsuarioMapper usuarioMapper;
    private JWTUtil jwtUtilInstance;
    @Value("${jwt.encryptor.password}")
    private String encryptKey;

    public AuthenticatorServiceImpl(UsuarioMapper usuarioMapper) {
        this.jwtUtilInstance = JWTUtil.getInstance();
        this.usuarioMapper=usuarioMapper;
    }

    public void authentica(String rolObjetivo, String jwt) throws ServiceException{
        String correo = this.jwtUtilInstance.getCorreoFromJwt(jwt, this.encryptKey);
        List<Rol> rolesUsuario = usuarioMapper.getRoles(correo);
        for(Rol x : rolesUsuario) {
            if(x.getNombre().equals(rolObjetivo)){
                return;
            }
        }
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);
    }

}
