package br.com.nexus.finance_manage_system.auth;

import br.com.nexus.finance_manage_system.security.AuthorizationService;
import br.com.nexus.finance_manage_system.security.TokenService;
import br.com.nexus.finance_manage_system.security.dto.RegisterRequest;
import br.com.nexus.finance_manage_system.security.dto.RegisterResponse;
import br.com.nexus.finance_manage_system.security.dto.LoginRequest;
import br.com.nexus.finance_manage_system.security.dto.LoginResponse;
import br.com.nexus.finance_manage_system.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final AuthorizationService authorizationService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService, AuthorizationService authorizationService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = (User) authentication.getPrincipal();
        if(user == null) {
            throw new IllegalCallerException("User does not exist");
        }
        return ResponseEntity.ok(new LoginResponse(tokenService.generateToken(user)));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse user =  this.authorizationService.createNewUser(request);
        return ResponseEntity.ok(user);
    }
}