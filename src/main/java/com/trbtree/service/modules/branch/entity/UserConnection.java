package com.trbtree.service.modules.branch.entity;

import com.trbtree.service.modules.branch.enums.ConnectionStatus;
import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "user_connections",
        uniqueConstraints = @UniqueConstraint(columnNames = {"requester_id", "addressee_id"})
)
@Getter
@Setter
public class UserConnection {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressee_id", nullable = false)
    private User addressee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConnectionStatus status;

    private Instant createdAt = Instant.now();
    private Instant respondedAt;
}
