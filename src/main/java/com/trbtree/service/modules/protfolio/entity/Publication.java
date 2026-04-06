package com.trbtree.service.modules.protfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profile_publications", schema = "trbtree")
@Getter
@Setter
public class Publication {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String title;
    private LocalDate publicationDate;
    private String publisher;

    private String url;
    private String description;

    private Short displayOrder;
    private OffsetDateTime createdAt;
}