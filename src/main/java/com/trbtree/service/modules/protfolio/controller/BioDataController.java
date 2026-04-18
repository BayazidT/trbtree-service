package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.BioDataRequest;
import com.trbtree.service.modules.protfolio.dto.BioDataResponse;
import com.trbtree.service.modules.protfolio.service.BioDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/bio-data")
@RequiredArgsConstructor
public class BioDataController {

    private final BioDataService bioDataService;

    @GetMapping("/{userId}")
    public ResponseEntity<BioDataResponse> getBioData(@PathVariable UUID userId) {
        BioDataResponse response = bioDataService.getBioData(userId);
        return ResponseEntity.ok(null);

    }

}
