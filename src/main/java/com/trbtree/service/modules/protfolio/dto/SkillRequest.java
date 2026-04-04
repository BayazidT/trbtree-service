package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

@Data
public class SkillRequest {
    private String category;
    private String skillName;
    private String proficiency;
    private Short yearsOfExperience;
}