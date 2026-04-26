package com.trbtree.service.modules.branch.dto;

import com.trbtree.service.modules.branch.enums.ConnectionStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RespondConnectionRequest {
    private UUID connectionId;
    private ConnectionStatus action; // ACCEPTED or REJECTED
}