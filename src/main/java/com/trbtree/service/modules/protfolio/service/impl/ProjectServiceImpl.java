package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import com.trbtree.service.modules.protfolio.service.ProjectService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectResponse> getProject(UUID userId) {
        return List.of();
    }
}
