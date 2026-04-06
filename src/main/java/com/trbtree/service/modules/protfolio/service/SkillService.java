package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface SkillService {

    List<SkillResponse> getSkill(UUID userId);
}
