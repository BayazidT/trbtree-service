package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.BioData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BioDataRepository extends JpaRepository<BioData, UUID> {
    BioData findByUserId(UUID userId);
}
