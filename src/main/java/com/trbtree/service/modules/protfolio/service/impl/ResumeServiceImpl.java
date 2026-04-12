package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.*;
import com.trbtree.service.modules.protfolio.service.*;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final SkillService skillService;
    private final ProjectService projectService;
    private final LanguageService languageService;
    private final CertificationService certificationService;
    private final PublicationService publicationService;
    private final HobbyService hobbyService;

    @Override
    public ResumeResponse getResumeDetails(UUID userId) {
        List<EducationResponse> educationResponses = educationService.getEducationByUserId(userId);
        List<ExperienceResponse> experienceResponses = experienceService.getExperience(userId);
        List<SkillResponse> skillResponses = skillService.getSkill(userId);
        List<ProjectResponse> projectResponses = projectService.getProject(userId);
        List<CertificationResponse> certificationResponses = certificationService.getCertifications(userId);
        List<PublicationResponse> publicationResponses = publicationService.getPublications(userId);
        List<LanguageResponse> languageResponses = languageService.getLanguages(userId);
        List<HobbyResponse> hobbyResponses = hobbyService.getHobbies(userId);
        return ResumeResponse
                .builder()
                .educations(educationResponses)
                .experiences(experienceResponses)
                .skills(skillResponses)
                .projects(projectResponses)
                .certifications(certificationResponses)
                .publications(publicationResponses)
                .languages(languageResponses)
                .hobbies(hobbyResponses)
                .build();
    }
}
