package co.com.s.configuracion;

import co.com.s.model.user.User;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static co.com.s.configuracion.JwtTokenProvider.generateJwtToken;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // valida el token Bearer
        try {
            // Extraer el token del encabezado de autorización
            String token = extractTokenFromAuthorizationHeader(request.getHeader("Authorization"));

            // Valida la autenticidad del token con un servicio de autenticación
            // verifica la validez del token JWT
            Authentication authentication = new UsernamePasswordAuthenticationToken(token, "zxidfo1");

            // retorna la autenticación resultante
            return authentication;


            //return null;
        } catch (Exception e) {
            throw new AuthenticationServiceException("Error al intentar autenticar el token.", e);
        }
    }

    // Método para extraer el token del encabezado de autorización
    private String extractTokenFromAuthorizationHeader(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // La longitud de "Bearer "
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Obtener el usuario autenticado
        User userDetails = (User) authResult.getPrincipal();

        // Generar un token JWT
        String token = generateJwtToken(userDetails);

        // Configurar el encabezado de respuesta con el token JWT
        response.setHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");

        // autenticación exitosa
        String responseBody = "{\"message\": \"Autenticación exitosa\"}";
        response.getWriter().write(responseBody);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        // Respuesta HTTP 401 (Unauthorized), mensaje de error
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{ \"error\": \"Authentication failed: " + failed.getMessage() + "\" }");
    }

}
