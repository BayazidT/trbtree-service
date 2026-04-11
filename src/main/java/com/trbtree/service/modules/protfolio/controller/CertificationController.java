package com.trbtree.service.modules.protfolio.controller;

import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import com.trbtree.service.modules.protfolio.entity.Certification;
import com.trbtree.service.modules.protfolio.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/certification")
@RequiredArgsConstructor
public class CertificationController {
    private final CertificationService certificationService;


    @GetMapping("/{userId}")
    public ResponseEntity<List<CertificationResponse>> getCertification(@PathVariable UUID userId) {
        List<CertificationResponse> responseList = certificationService.getCertifications(userId);
        return ResponseEntity.ok(responseList);
    }
    @PostMapping("/{userId}")
    public ResponseEntity<CertificationResponse> addCertification(@PathVariable UUID userId, @RequestBody CertificationRequest request) {
        CertificationResponse response = certificationService.addCertification(request, userId);
        return ResponseEntity.ok(response);
    }


}
