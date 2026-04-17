package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SkillResponse {
    private UUID id;
    private String category;
    private String skillName;
    private String proficiency;
    private Short yearsOfExperience;
}