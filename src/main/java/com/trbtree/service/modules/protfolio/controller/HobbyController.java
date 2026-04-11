package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.HobbyRequest;
import com.trbtree.service.modules.protfolio.dto.HobbyResponse;
import com.trbtree.service.modules.protfolio.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/hobby")
@RequiredArgsConstructor
public class HobbyController {
    private final HobbyService hobbyService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<HobbyResponse>> getHobby(@PathVariable UUID userId) {
        List<HobbyResponse> responseList = hobbyService.getHobbies(userId);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<HobbyResponse> addHobby(@PathVariable UUID userId, @RequestBody HobbyRequest hobbyRequest) {
        HobbyResponse response = hobbyService.addHobby(hobbyRequest, userId);
        return ResponseEntity.ok(response);
    }
}
