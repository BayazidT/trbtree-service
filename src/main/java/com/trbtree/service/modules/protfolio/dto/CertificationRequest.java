package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificationRequest {
    private String title;
    private String issuingOrganization;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String credentialId;
    private String credentialUrl;
    private String description;
}