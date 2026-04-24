package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationRepository extends JpaRepository<Conversation, UUID> {
}
