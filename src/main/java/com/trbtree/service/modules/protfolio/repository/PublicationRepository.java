package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {
    List<Publication> findByUserId(UUID userId);
}
