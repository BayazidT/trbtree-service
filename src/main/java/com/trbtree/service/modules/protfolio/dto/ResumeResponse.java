package com.trbtree.service.modules.protfolio.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResumeResponse {
    List<EducationResponse> educations;
    List<ExperienceResponse> experiences;
    List<SkillResponse> skills;
    List<CertificationResponse> certifications;
    List<ProjectResponse> projects;
    List<HobbyResponse> hobbies;
    List<LanguageResponse> languages;
    List<PublicationResponse> publications;
}
