package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
import com.trbtree.service.modules.protfolio.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    List<LanguageResponse> findByUserId(UUID userId);
}
