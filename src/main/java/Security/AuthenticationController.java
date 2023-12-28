package Security;

import User.UserService;
import ch.ethz.ssh2.auth.AuthenticationManager;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    public AuthenticationController(
            AuthenticationManager authenticationManager,
            JwtTokenUtil jwtTokenUtil,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }


        @PostMapping("/login")
        public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequestDto authenticationRequest) {
            try {
                // Autenticar al usuario utilizando el AuthenticationManager
                Neo4jProperties.Authentication authentication = authenticationManager.authenticatePassword(
                        new UsernamePasswordAuthenticationToken(
                                authenticationRequest.getUsername(),
                                authenticationRequest.getPassword()
                        )
                );

                // Si la autenticación es exitosa, se genera un token JWT
                final UserDetailsServiceAutoConfiguration userDetails = (UserDetailsServiceAutoConfiguration) authentication.getPrincipal();
                final String token = jwtTokenUtil.generateToken(userDetails);

                // Devolver el token como respuesta si la autenticación es exitosa
                return ResponseEntity.ok(new LoginResponseDto(token));
            } catch (AuthenticationException e) {
                // Manejar la excepción si la autenticación falla
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        // Aquí maneja el registro de un nuevo usuario
        // Usa el userService para crear un nuevo usuario en tu sistema
        // Devuelve un mensaje de éxito o código de estado apropiado
    }
}