package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
import com.trbtree.service.modules.protfolio.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<LanguageResponse>> getLanguages(@PathVariable UUID userId) {
        List<LanguageResponse> responseList = languageService.getLanguages(userId);
        return ResponseEntity.ok(responseList);
    }
}
