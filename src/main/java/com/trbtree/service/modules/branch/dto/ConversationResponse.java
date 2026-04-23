package com.trbtree.service.modules.branch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ConversationResponse {

    private UUID conversationId;
    private String type;

    private UUID otherUserId;   // for DIRECT chat
    private String otherUsername;

    private String lastMessage;
    private Instant lastMessageAt;

    private long unreadCount;
}
