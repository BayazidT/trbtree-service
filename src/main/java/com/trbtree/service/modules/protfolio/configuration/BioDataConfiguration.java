package com.trbtree.service.modules.protfolio.configuration;


import com.trbtree.service.modules.protfolio.mapper.BioDataMapper;
import com.trbtree.service.modules.protfolio.repository.BioDataRepository;
import com.trbtree.service.modules.protfolio.service.BioDataService;
import com.trbtree.service.modules.protfolio.service.impl.BioDataServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@RequiredArgsConstructor
public class BioDataConfiguration {
    private final BioDataMapper bioDataMapper;
    private final BioDataRepository bioDataRepository;
    @Bean
    public BioDataService bioDataService() {
        return new BioDataServiceImpl(bioDataMapper, bioDataRepository);
    }
}
