package com.trbtree.service.modules.protfolio.configuration;

import com.trbtree.service.modules.protfolio.service.*;
import com.trbtree.service.modules.protfolio.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@RequiredArgsConstructor
public class ResumeConfiguration {
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final SkillService skillService;
    private final ProjectService projectService;
    private final LanguageService languageService;
    private final CertificationService certificationService;
    private final PublicationService publicationService;
    private final HobbyService hobbyService;
    @Bean
    public ResumeService getResumeServiceImpl(){
        return new ResumeServiceImpl(educationService,
                experienceService,
                skillService,
                projectService,
                languageService,
                certificationService,
                publicationService,
                hobbyService);
    }
}
