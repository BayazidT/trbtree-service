package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.ProjectRequest;
import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
public interface ProjectService {
    List<ProjectResponse> getProject(UUID userId);

    ProjectResponse createProject(ProjectRequest request, UUID userId);
}
