package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> {
    List<Education> findByUserId(UUID userId);
}
