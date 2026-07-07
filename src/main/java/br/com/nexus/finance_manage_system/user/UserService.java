package br.com.nexus.finance_manage_system.user;

import br.com.nexus.finance_manage_system.dto.UserResponseDTO;
import br.com.nexus.finance_manage_system.exception.InvalidCredentialsException;
import br.com.nexus.finance_manage_system.exception.UnauthorizedException;
import br.com.nexus.finance_manage_system.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> findAllUsers(){
        List<User> users =  this.userRepository.findAll();

        return users.stream().map((u) -> new UserResponseDTO(u.getId(), u.getName(), u.getEmail())).toList();
    }

    public UserResponseDTO updateUserName(User user, String userName) {
        user.setName(userName);
        user.setUpdatedAt(OffsetDateTime.now());
        User updatedUser = this.userRepository.save(user);
        return new UserResponseDTO(updatedUser);
    }

    public UserResponseDTO updateUserEmail(User user, String email){
        user.setEmail(email);
        user.setUpdatedAt(OffsetDateTime.now());
        User updatedUser = this.userRepository.save(user);
        return new UserResponseDTO(updatedUser);
    }

    public UserResponseDTO updateUserStatus(User user, Boolean userStatus) {
        user.setIsActive(userStatus);
        user.setUpdatedAt(OffsetDateTime.now());

        User updatedUser = this.userRepository.save(user);
        return new UserResponseDTO(updatedUser);
    }

    public UserResponseDTO updatePassword(User user, String oldPassword, String newPassword) {

        if(!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new InvalidCredentialsException();
        }
        user.setPasswordHash(passwordEncoder.encode(newPassword));
        user.setUpdatedAt(OffsetDateTime.now());
        User updatedUser = this.userRepository.save(user);
        return new  UserResponseDTO(updatedUser);
    }
}
