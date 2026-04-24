package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.ConversationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationParticipantRepository extends JpaRepository<ConversationParticipant, UUID> {
}
