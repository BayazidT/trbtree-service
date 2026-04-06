package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import com.trbtree.service.modules.protfolio.mapper.SkillMapper;
import com.trbtree.service.modules.protfolio.repository.SkillRepository;
import com.trbtree.service.modules.protfolio.service.SkillService;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    @Override
    public List<SkillResponse> getSkill(UUID userId) {
        return Optional.ofNullable(skillRepository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(skillMapper::toDTO)
                .toList();
    }
}
