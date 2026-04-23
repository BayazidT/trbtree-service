package com.trbtree.service.modules.branch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SendMessageRequest {
    private UUID conversationId;   // optional for new chat
    private UUID receiverId;       // used if conversationId is null
    private String content;
}