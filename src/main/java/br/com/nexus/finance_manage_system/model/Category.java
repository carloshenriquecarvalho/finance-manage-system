package br.com.nexus.finance_manage_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private OffsetDateTime joinedAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "cost_center_id")
    private CostCenter costCenter;

    @OneToMany(mappedBy = "category")
    private Set<Transaction> transactions = new HashSet<>();
}
