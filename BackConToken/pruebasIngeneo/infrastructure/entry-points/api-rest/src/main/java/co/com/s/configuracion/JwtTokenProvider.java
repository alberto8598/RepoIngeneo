package co.com.s.configuracion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;
import co.com.s.model.user.User;

public class JwtTokenProvider {

    private static final String SECRET_KEY = "zxidfo1"; // Clave secreta para firmar el token
    private static final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos

    public static String generateJwtToken(User userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userDetails.getName())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
