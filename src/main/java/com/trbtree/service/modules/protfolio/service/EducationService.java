package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.EducationRequest;
import com.trbtree.service.modules.protfolio.dto.EducationResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface EducationService {
    EducationResponse createEducation(EducationRequest educationRequest, UUID userId);
}
