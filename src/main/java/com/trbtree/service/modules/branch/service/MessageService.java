package com.trbtree.service.modules.branch.service;

import com.trbtree.service.modules.branch.dto.SendMessageRequest;

import java.util.UUID;

public interface MessageService {
    void sendMessage(UUID userId, SendMessageRequest message);
}
