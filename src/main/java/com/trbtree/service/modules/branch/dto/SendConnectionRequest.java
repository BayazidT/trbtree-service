package com.trbtree.service.modules.branch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SendConnectionRequest {
    private UUID addresseeId;
}