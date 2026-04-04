package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LanguageResponse {
    private UUID id;
    private String languageName;
    private String proficiency;
}
