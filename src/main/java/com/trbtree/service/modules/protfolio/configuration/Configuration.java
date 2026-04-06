package com.trbtree.service.modules.protfolio.configuration;

import com.trbtree.service.modules.protfolio.mapper.EducationMapper;
import com.trbtree.service.modules.protfolio.mapper.SkillMapper;
import com.trbtree.service.modules.protfolio.repository.EducationRepository;
import com.trbtree.service.modules.protfolio.repository.SkillRepository;
import com.trbtree.service.modules.protfolio.service.EducationService;
import com.trbtree.service.modules.protfolio.service.SkillService;
import com.trbtree.service.modules.protfolio.service.impl.EducationServiceImpl;
import com.trbtree.service.modules.protfolio.service.impl.SkillServiceImpl;
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

    @Bean
    public EducationService getEducationServiceImpl(){
        return new EducationServiceImpl(educationRepository, userRepository, educationMapper);
    }

    @Bean
    public SkillService getSkillServiceImpl(){
        return new SkillServiceImpl(skillRepository, skillMapper);
    }
}
