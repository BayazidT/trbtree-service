package com.trbtree.service.modules.protfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profile_hobbies", schema = "trbtree",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "name"}))
@Getter
@Setter
public class Hobby {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String name;

    private Short displayOrder;
    private OffsetDateTime createdAt;
}