package com.trbtree.service.modules.protfolio.configuration;

import com.trbtree.service.modules.protfolio.mapper.*;
import com.trbtree.service.modules.protfolio.repository.*;
import com.trbtree.service.modules.protfolio.service.*;
import com.trbtree.service.modules.protfolio.service.impl.*;
import com.trbtree.service.modules.user.repository.UserRepository;
import com.trbtree.service.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@RequiredArgsConstructor
public class Configuration {
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;
    private final EducationMapper educationMapper;
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;
    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper;
    private final HobbyRepository hobbyRepository;
    private final HobbyMapper hobbyMapper;
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Bean
    public EducationService getEducationServiceImpl(){
        return new EducationServiceImpl(educationRepository, userRepository, educationMapper);
    }

    @Bean
    public SkillService getSkillServiceImpl(){
        return new SkillServiceImpl(skillRepository, skillMapper);
    }

    @Bean
    public ProjectService getProjectServiceImpl(){
        return new ProjectServiceImpl(projectRepository, projectMapper);
    }

    @Bean
    public ExperienceService getExperienceService(){
        return new ExperienceServiceImpl(experienceRepository, experienceMapper);
    }

    @Bean
    public CertificationService getCertificationServiceImpl(){
        return new CertificationServiceImpl(certificationRepository, certificationMapper);
    }

    @Bean
    public HobbyService getHobbyServiceImpl(){
        return new HobbyServiceImpl(hobbyRepository, hobbyMapper);
    }

    @Bean
    public LanguageService getLanguageServiceImpl(){
        return new LanguageServiceImpl(languageRepository, languageMapper);
    }
}

