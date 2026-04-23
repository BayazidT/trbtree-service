package com.trbtree.service.modules.branch.entity;

import com.trbtree.service.modules.branch.enums.ConversationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "conversations")
@Getter
@Setter
public class Conversation {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConversationType type = ConversationType.DIRECT;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    private UUID lastMessageId;
    private Instant lastMessageAt;
}
