package com.trbtree.service.modules.branch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ConnectionResponse {

    private UUID id;

    private UUID requesterId;
    private UUID addresseeId;

    private String requesterName;
    private String addresseeName;

    private String status;

    private Instant createdAt;
    private Instant respondedAt;
}