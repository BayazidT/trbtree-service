package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.ResumeResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ResumeService {
    ResumeResponse getResumeDetails(UUID userId);
}
