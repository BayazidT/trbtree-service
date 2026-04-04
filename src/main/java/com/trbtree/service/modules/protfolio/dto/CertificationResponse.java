package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CertificationResponse {
    private UUID id;
    private String title;
    private String issuingOrganization;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String credentialId;
    private String credentialUrl;
    private String description;
}