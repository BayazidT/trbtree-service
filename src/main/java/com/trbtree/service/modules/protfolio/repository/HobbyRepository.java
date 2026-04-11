package com.trbtree.service.modules.protfolio.repository;

import com.trbtree.service.modules.protfolio.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HobbyRepository extends JpaRepository<Hobby, UUID> {
    List<Hobby> findByUserId(UUID userId);
}
