package com.trbtree.service.modules.branch.service;

import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.dto.SendMessageRequest;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    void sendMessage(UUID userId, SendMessageRequest message);

    List<MessageResponse> getMessage(UUID conversationId);
}
