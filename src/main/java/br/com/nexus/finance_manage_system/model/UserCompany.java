package br.com.nexus.finance_manage_system.model;

import br.com.nexus.finance_manage_system.company.Company;
import br.com.nexus.finance_manage_system.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS_COMPANIES")
public class UserCompany {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
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
