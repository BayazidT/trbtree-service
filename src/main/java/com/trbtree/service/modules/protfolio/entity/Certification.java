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
@Table(name = "profile_certifications")
@Getter
@Setter
public class Certification {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String title;
    private String issuingOrganization;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    private String credentialId;
    private String credentialUrl;

    private String description;

    private Short displayOrder;
    private OffsetDateTime createdAt;
}