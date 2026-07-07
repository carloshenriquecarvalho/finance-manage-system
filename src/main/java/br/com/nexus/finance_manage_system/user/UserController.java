package br.com.nexus.finance_manage_system.user;

import java.util.List;
import java.util.Set;

import br.com.nexus.finance_manage_system.dto.*;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findUsers(@AuthenticationPrincipal User user){
         return ResponseEntity.ok(this.userService.findAllUsers());
    }

    @PutMapping("/update/name")
    public ResponseEntity<UserResponseDTO> updateUserName(@RequestBody UpdateUserNameDTO request, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(this.userService.updateUserName(user, request.name()));
    }

    @PutMapping("/update/email")
    public ResponseEntity<UserResponseDTO> updateEmail(@RequestBody UpdateUserEmailDTO request, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(this.userService.updateUserEmail(user, request.email()));
    }

    @PutMapping("/update/user-status")
    public ResponseEntity<UserResponseDTO> updateUserStatus(@RequestBody UpdateUserStatusDTO request, @AuthenticationPrincipal User user){
        return ResponseEntity.ok(this.userService.updateUserStatus(user, request.userStatus()));
    }

    @PutMapping("/update/password")
    public ResponseEntity<UserResponseDTO> updateUserPassword(@RequestBody UpdateUserPassword request, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(this.userService.updatePassword(user, request.oldPassword(), request.newPassword()));
    }

    @GetMapping("/me")
    public ResponseEntity<UserMeResponseDTO> getUserMe(@AuthenticationPrincipal User user){

        return ResponseEntity.ok(new UserMeResponseDTO(user));
    }
}
