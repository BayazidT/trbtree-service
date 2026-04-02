package com.trbtree.service.modules.protfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profile_skills",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "category", "skill_name"}))
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    private String skillName;
    private String proficiency;
    private Short yearsOfExperience;

    private Short displayOrder;
    private OffsetDateTime createdAt;
}