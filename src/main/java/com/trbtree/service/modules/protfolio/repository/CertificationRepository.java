package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {
    List<Certification> findByUserId(UUID userId);
}
