package mx.unam.backend.utils;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import mx.unam.backend.exceptions.*;

/**
 * Clase JWTUtil.
 *
 * @author garellano
 * @version $Id: $Id
 */
public class JWTUtil {
    private static JWTUtil instance = null;
    private final String contacto = "contacta a tu administrador";

    private JWTUtil() {
    }

    /**
     * <p>Getter for the field <code>instance</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.utils.JWTUtil} object.
     */
    public static JWTUtil getInstance() {
        if(instance==null) {
            instance = new JWTUtil();
        }
        return instance;
    }
    
    /**
     * <p>createToken.</p>
     *
     * @param username a {@link java.lang.String} object.
     * @param securityTokenLasts a int.
     * @param encryptKey a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String createToken(final String username, int securityTokenLasts, String encryptKey) {
        if(encryptKey == null){
            encryptKey = "secreto";
        }
        byte[] key = encryptKey.getBytes();

        Calendar calendar = Calendar.getInstance();
        Date issued = calendar.getTime();

        calendar.add(Calendar.MINUTE, securityTokenLasts);
        Date expiration = calendar.getTime();

        final JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuer("crypto-executor-jwtManager");
        jwtBuilder.setIssuedAt(issued);
        jwtBuilder.setSubject("Cool jwt Token on: " + System.currentTimeMillis());
        jwtBuilder.setId(username);
        jwtBuilder.setExpiration(expiration);
        return jwtBuilder.signWith(SignatureAlgorithm.HS256, key).compact();
    }

    /**
     * Checa si un token dado (con estructira correcta) ha sido firmado adecuadamente.
     * En caso de que sea un token con una estructira inválida o no esté firmado de una
     * manera adecuada, dispara una excepción. Si todo esta bien, retorna "true".
     * <p> Es interesante mencionar que si a cadena jwt es verificada exitosamente, entonces
     * es posible parsear (hacer decode) al jwt de manera simple y confiar en la decodificación.
     * Ver decodeJwt para un decode en forma de cadena json.
     *
     * @param jwt Cadena jwt a verificar
     * @param encryptKey Clave de encripción
     *
     * @return Cadena jwt decodificada
     * @throws CustomException
     */
    public String revisaToken(String jwt, String encryptKey) throws ServiceException {
        try {
            Jwts
               .parser()
               .setSigningKey(encryptKey.getBytes())
               .parseClaimsJws(jwt).getBody();
            return decodeJwt(jwt);
        } catch(ExpiredJwtException e) {
            throw new ServiceException(e, "el token ya ha expirado", e.getMessage() ,
             10000, contacto , HttpStatus.BAD_REQUEST);
        } catch(SignatureException e) {
            throw new ServiceException(e, "el token tiene una firma invalida", e.getMessage() ,
             10000, contacto, HttpStatus.BAD_REQUEST);
        } catch(MalformedJwtException e) {
            throw new ServiceException(e, "el token tiene una estructura invalida", e.getMessage() ,
             10000, contacto, HttpStatus.BAD_REQUEST);
        } catch(UnsupportedJwtException e) {
            throw new ServiceException(e, "el token es el equivocado", e.getMessage() ,
             10000, contacto, HttpStatus.BAD_REQUEST);
        } catch(IllegalArgumentException e) {
            throw new ServiceException(e, "error del lado del servidor", e.getMessage() ,
             10000, contacto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public String decodeJwt(String jwt) {
        String[] chunks = jwt.split("\\.");
        if(chunks.length<3) throw new RuntimeException("Bad jwt");
        Base64.Decoder decoder = Base64.getDecoder();

        try {
            String payload = new String(decoder.decode(chunks[1]));


            return payload;
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Bad jwt");
        }
    }
    
    private String getValueFromDecodedJwtString(String decodedJwt, String field) {
        String[] partes = decodedJwt.substring(1, decodedJwt.length()-1).replaceAll("\"", "").split(",");
        Map<String, String> mapa = new HashMap<>();
        for(String parte : partes) {
            String[] d = parte.split(":");
            mapa.put(d[0], d[1]);
        }
        return mapa.get(field);
    }
    
    public String getCorreoFromJwt(String jwt, String encryptKey) throws ServiceException{
        if(encryptKey == null){
            encryptKey = "secreto";
        }
        String decodedJwt = revisaToken( jwt, encryptKey);
        return getValueFromDecodedJwtString(decodedJwt, "jti");
    }

    public long getExpirationFromDecoded(String decodedJwt) {
        String expStr = getValueFromDecodedJwtString(decodedJwt, "exp");
        return Long.valueOf(expStr);
    }


}