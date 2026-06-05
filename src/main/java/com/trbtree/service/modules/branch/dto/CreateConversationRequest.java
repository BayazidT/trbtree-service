package com.trbtree.service.modules.branch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateConversationRequest {
    private List<UUID> participantIds;
    private UUID participantId;
}