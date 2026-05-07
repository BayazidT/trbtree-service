package com.trbtree.service.modules.tree.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PostResponse {

    private UUID id;

    private UUID userId;
    private String username;

    private String content;

    private String visibility;

    private Integer likeCount;
    private Integer commentCount;

    private Instant createdAt;
    private Instant updatedAt;
}