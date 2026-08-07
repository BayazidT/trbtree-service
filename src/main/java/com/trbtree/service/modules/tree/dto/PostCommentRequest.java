package com.trbtree.service.modules.tree.dto;

import com.trbtree.service.modules.tree.enums.PostVisibility;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PostCommentRequest {

    private String comment;
    private UUID postId;
    private UUID userId;

}