package com.trbtree.service.modules.tree.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostCommentListResponse {
    private List<PostCommentResponse> content;
}
