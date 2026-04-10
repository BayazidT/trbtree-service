package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.ExperienceRequest;
import com.trbtree.service.modules.protfolio.dto.ExperienceResponse;
import com.trbtree.service.modules.protfolio.entity.Experience;
import com.trbtree.service.modules.protfolio.mapper.ExperienceMapper;
import com.trbtree.service.modules.protfolio.repository.ExperienceRepository;
import com.trbtree.service.modules.protfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository repository;
    private final ExperienceMapper experienceMapper;

    @Override
    public ExperienceResponse createExperience(ExperienceRequest experienceRequest, UUID userId) {
        Experience experience = experienceMapper.toEntity(experienceRequest);
        experience.setUserId(userId);
        return experienceMapper.toDTO(repository.save(experience));
    }

    @Override
    public List<ExperienceResponse> getExperience(UUID userId) {
        return Optional.ofNullable(repository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(experienceMapper::toDTO)
                .toList();
    }
}
