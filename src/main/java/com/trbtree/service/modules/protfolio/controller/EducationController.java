package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.EducationRequest;
import com.trbtree.service.modules.protfolio.dto.EducationResponse;
import com.trbtree.service.modules.protfolio.service.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/{userId}")
    public ResponseEntity<EducationResponse> createEducation(@Valid @RequestBody EducationRequest educationRequest, @PathVariable UUID userId) {
        EducationResponse response = educationService.createEducation(educationRequest, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<EducationResponse>> getEducation(@PathVariable UUID userId) {
        List<EducationResponse> responseList = educationService.getEducationByUserId(userId);
        return ResponseEntity.ok(responseList);
    }
}
