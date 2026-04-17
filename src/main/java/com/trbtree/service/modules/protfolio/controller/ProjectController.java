package com.trbtree.service.modules.protfolio.controller;

import com.trbtree.service.modules.protfolio.dto.ProjectRequest;
import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import com.trbtree.service.modules.protfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{userId}")
    public ResponseEntity<ProjectResponse> createProject(@PathVariable UUID userId, @RequestBody ProjectRequest request) {
        ProjectResponse response = projectService.createProject(request, userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable UUID id, @RequestBody ProjectRequest request) {
        ProjectResponse response = projectService.updateProject(request, id);
        return ResponseEntity.ok(response);
    }
}
