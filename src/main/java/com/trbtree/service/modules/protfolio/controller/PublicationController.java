package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.PublicationRequest;
import com.trbtree.service.modules.protfolio.dto.PublicationResponse;
import com.trbtree.service.modules.protfolio.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/publication")
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<PublicationResponse>> getPublications(@PathVariable UUID userId) {
        List<PublicationResponse> responseList = publicationService.getPublications(userId);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<PublicationResponse> addPublication(@PathVariable UUID userId, @RequestBody PublicationRequest publicationRequest) {
        PublicationResponse response = publicationService.addPublication(publicationRequest, userId);
        return ResponseEntity.ok(response);
    }
}
