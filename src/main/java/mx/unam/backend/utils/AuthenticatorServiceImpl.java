/*
 *
 * Paquete:     mx.unam.backend.model
 * Proyecto:    licenciatura-backend
 * Tipo:        Class
 * Nombre:      AuthenticatorServiceImpl
 * Autor:       Luis Martinez 
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:
 *              Creación: 21 Mar 2022
 */
package mx.unam.backend.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.unam.backend.exceptions.CustomException;
import mx.unam.backend.exceptions.ServiceException;
import mx.unam.backend.mapper.UsuarioMapper;
import mx.unam.backend.model.Rol;
/**
 * <p>Implementación de la interfaz {@link mx.unam.backend.service.AuthenticatorService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link mx.unam.backend.exceptions.ServiceException}
 *
 * @author  mentesniker
 * @see     unam.mx.backend.domain.Usuario
 * @see     mx.unam.backend.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
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
    /** {@inheritDoc} */
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
