package com.trbtree.service.modules.branch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ConnectedUserResponse {

    private UUID userId;
    private String username;
    private String name;
}