package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.ConversationParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ConversationParticipantRepository extends JpaRepository<ConversationParticipant, UUID> {
//    @Query()
    List<ConversationParticipant> findByUserId(UUID userId);

    List<ConversationParticipant> findByConversationId(UUID id);

    @Query("""
    SELECT cp.conversation.id
    FROM ConversationParticipant cp
    WHERE (cp.user.id = :userId
       OR cp.user.id = :participantId)
""")
    List<UUID> checkIfConversationExist(UUID userId, UUID participantId);
}
