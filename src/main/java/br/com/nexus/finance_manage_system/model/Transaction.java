package br.com.nexus.finance_manage_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "current_type")
    private String currentType;

    @Column(name = "reminder_at")
    private OffsetDateTime reminderAt;

    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "paid_at")
    private OffsetDateTime paidAt;

    @Column(name = "due_date")
    private OffsetDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "transaction")
    private Set<Attachment> attachments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
