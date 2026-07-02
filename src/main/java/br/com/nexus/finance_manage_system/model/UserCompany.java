package br.com.nexus.finance_manage_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS_COMPANIES")
public class UserCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "current_user_role")
    private String role;

    @Column(name = "joined_at")
    private OffsetDateTime joinedAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}
