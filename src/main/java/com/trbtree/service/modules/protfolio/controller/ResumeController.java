package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.ResumeResponse;
import com.trbtree.service.modules.protfolio.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResumeResponse> getResumeDetails(@PathVariable UUID userId) {
        ResumeResponse response = resumeService.getResumeDetails(userId);
        return ResponseEntity.ok(response);
    }
}
