package br.com.nexus.finance_manage_system.security;

import br.com.nexus.finance_manage_system.exception.EmailAlreadyExistsException;
import br.com.nexus.finance_manage_system.exception.InvalidCredentialsException;
import br.com.nexus.finance_manage_system.security.dto.RegisterRequest;
import br.com.nexus.finance_manage_system.security.dto.RegisterResponse;
import br.com.nexus.finance_manage_system.user.User;
import br.com.nexus.finance_manage_system.user.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username)  throws UsernameNotFoundException{
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public RegisterResponse createNewUser(RegisterRequest registerRequest){
        if(registerRequest.name().isEmpty() || registerRequest.email().isEmpty() || registerRequest.password().isEmpty()) {
            throw new InvalidCredentialsException();
        }

        if(userRepository.findByEmail(registerRequest.email()).isEmpty()) {
            String hash = passwordEncoder.encode(registerRequest.password());

            User user = new User();
            user.setName(registerRequest.name());
            user.setEmail(registerRequest.email());
            user.setPasswordHash(hash);
            user.setCreatedAt(OffsetDateTime.now());
            user.setIsActive(true);
            User registeredUser =  userRepository.save(user);

            return new RegisterResponse(String.valueOf(registeredUser.getId()), registeredUser.getName());
        } else {

            throw new EmailAlreadyExistsException();
        }
    }
}
