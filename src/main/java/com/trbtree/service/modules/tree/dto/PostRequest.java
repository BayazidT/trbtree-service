package com.trbtree.service.modules.tree.dto;

import com.trbtree.service.modules.tree.enums.PostVisibility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private String content;

    private PostVisibility visibility; // optional (default PUBLIC)
}