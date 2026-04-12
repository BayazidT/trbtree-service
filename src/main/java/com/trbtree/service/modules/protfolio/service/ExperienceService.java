package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.ExperienceRequest;
import com.trbtree.service.modules.protfolio.dto.ExperienceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ExperienceService {
    List<ExperienceResponse> getExperience(java.util.UUID userId);

    ExperienceResponse createExperience(ExperienceRequest experienceRequest, UUID userId);

    ExperienceResponse updateExperience(ExperienceRequest experienceRequest, UUID id);
}
