package com.trbtree.service.modules.protfolio.controller;

import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import com.trbtree.service.modules.protfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping("/{userId}")
    public ResponseEntity<List<ProjectResponse>> getProject(@PathVariable UUID userId) {
        List<ProjectResponse> responseList = projectService.getProject(userId);
        return ResponseEntity.ok(responseList);
    }
}
