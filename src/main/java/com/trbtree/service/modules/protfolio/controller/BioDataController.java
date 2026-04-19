package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.BioDataRequest;
import com.trbtree.service.modules.protfolio.dto.BioDataResponse;
import com.trbtree.service.modules.protfolio.service.BioDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/bio-data")
@RequiredArgsConstructor
public class BioDataController {

    private final BioDataService bioDataService;

    @GetMapping("/{userId}")
    public ResponseEntity<BioDataResponse> getBioData(@PathVariable UUID userId) {
        BioDataResponse response = bioDataService.getBioData(userId);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/{userId}")
    public ResponseEntity<BioDataResponse> createBioData(@PathVariable UUID userId, @RequestBody BioDataRequest request) {
        BioDataResponse response = bioDataService.createBioData(userId, request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<BioDataResponse> updateBioData(@PathVariable UUID userId, @RequestBody BioDataRequest request) {
        BioDataResponse response = bioDataService.updateBioData(userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteBioData(@PathVariable UUID userId) {
         bioDataService.deleteBioData(userId);
        return ResponseEntity.ok("Deleted Successfully!");

    }


}
