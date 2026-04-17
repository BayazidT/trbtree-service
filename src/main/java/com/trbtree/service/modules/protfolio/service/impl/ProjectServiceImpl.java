package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.ProjectRequest;
import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import com.trbtree.service.modules.protfolio.entity.Project;
import com.trbtree.service.modules.protfolio.mapper.ProjectMapper;
import com.trbtree.service.modules.protfolio.repository.ProjectRepository;
import com.trbtree.service.modules.protfolio.service.ProjectService;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectResponse> getProject(UUID userId) {
        return Optional.ofNullable(projectRepository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(projectMapper::toDTO)
                .toList();
    }

    @Override
    public ProjectResponse updateProject(ProjectRequest request, UUID id) {
        Project oldProject = projectRepository.findById(id).orElse(null);
        Project project = projectMapper.toEntity(request);
        project.setUserId(oldProject.getUserId());
        projectRepository.delete(oldProject);
        projectRepository.save(project);
        return projectMapper.toDTO(project);    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, UUID userId) {
        Project project = projectMapper.toEntity(request);
        project.setUserId(userId);
        projectRepository.save(project);
        return projectMapper.toDTO(project);
    }
}
