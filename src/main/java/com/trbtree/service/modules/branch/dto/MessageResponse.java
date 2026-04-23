package com.trbtree.service.modules.branch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
    private UUID id;
    private UUID conversationId;
    private UUID senderId;
    private String content;
    private String messageType;
    private Instant createdAt;
}