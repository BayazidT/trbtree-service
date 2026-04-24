package com.trbtree.service.modules.branch.service;

import com.trbtree.service.modules.branch.dto.CreateConversationRequest;

public interface ConversationService {
    void startConversation(CreateConversationRequest request);
}
