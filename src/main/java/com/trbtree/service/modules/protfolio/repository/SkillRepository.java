package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
    List<Skill> findByUserId(UUID userId);
}
