package com.trbtree.service.modules.protfolio.controller;


import com.trbtree.service.modules.protfolio.dto.SkillRequest;
import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import com.trbtree.service.modules.protfolio.entity.Skill;
import com.trbtree.service.modules.protfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<SkillResponse>>getSkill(@PathVariable UUID userId) {
        List<SkillResponse> responseList = skillService.getSkill(userId);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<SkillResponse>createSkill(@PathVariable UUID userId, @RequestBody SkillRequest request) {
        SkillResponse response = skillService.createSkill(request, userId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}")
    public ResponseEntity<SkillResponse>updateSkill(@PathVariable UUID id, @RequestBody SkillRequest request) {
        SkillResponse response = skillService.updateSkill(request, id);
        return ResponseEntity.ok(response);
    }

}
