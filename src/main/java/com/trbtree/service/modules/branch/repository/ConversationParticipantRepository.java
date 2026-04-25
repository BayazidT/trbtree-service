package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.ConversationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ConversationParticipantRepository extends JpaRepository<ConversationParticipant, UUID> {
//    @Query()
    List<ConversationParticipant> findByUserId(UUID userId);

    List<ConversationParticipant> findByConversationId(UUID id);
}
