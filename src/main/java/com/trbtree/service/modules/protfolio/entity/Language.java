package com.trbtree.service.modules.protfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profile_languages", schema = "trbtree",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "language_name"}))
@Getter
@Setter
public class Language {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String languageName;
    private String proficiency;

    private Short displayOrder;
    private OffsetDateTime createdAt;
}