package br.com.nexus.finance_manage_system.dto;

import br.com.nexus.finance_manage_system.model.UserCompany;
import br.com.nexus.finance_manage_system.user.User;

import java.time.OffsetDateTime;
import java.util.Set;

public record UserMeResponseDTO(
        String name,
        String email,
        Boolean isActive,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
    public UserMeResponseDTO(User user){
        this(user.getName(), user.getEmail(), user.getIsActive(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
