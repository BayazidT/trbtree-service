package com.trbtree.service.modules.branch.service;

import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;

import java.util.List;
import java.util.UUID;

public interface ConversationService {
    void startConversation(CreateConversationRequest request, UUID userId);

    List<ConversationResponse> getConversations(UUID userId);
}
