package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.ExperienceRequest;
import com.trbtree.service.modules.protfolio.dto.ExperienceResponse;
import com.trbtree.service.modules.protfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExperienceResponse>> getExperience(@PathVariable UUID userId) {
        List<ExperienceResponse>  responseList = experienceService.getExperience(userId);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ExperienceResponse> createExperience(@PathVariable UUID userId, @RequestBody ExperienceRequest experienceRequest){
        ExperienceResponse response = experienceService.createExperience(experienceRequest, userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> updateExperience(@PathVariable UUID id, @RequestBody ExperienceRequest experienceRequest){
        ExperienceResponse response = experienceService.updateExperience(experienceRequest, id);
        return ResponseEntity.ok(response);
    }

}
