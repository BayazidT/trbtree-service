package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConnectionRepository extends JpaRepository<UserConnection, UUID> {
    List<UserConnection> findByAddresseeId(UUID userId);
}
