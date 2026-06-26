package com.trbtree.service.modules.tree.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class PostCommentResponse {
    private Integer id;
    private String comment;
    private String commenterName;
    private UUID commenterId;
    private Instant createdAt;
    private Instant updatedAt;

}