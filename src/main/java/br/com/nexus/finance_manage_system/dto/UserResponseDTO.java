package br.com.nexus.finance_manage_system.dto;

import br.com.nexus.finance_manage_system.user.User;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
