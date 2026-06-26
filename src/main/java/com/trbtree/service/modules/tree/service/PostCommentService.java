package com.trbtree.service.modules.tree.service;

import com.trbtree.service.modules.tree.dto.PostCommentListResponse;
import com.trbtree.service.modules.tree.dto.PostCommentRequest;
import com.trbtree.service.modules.tree.dto.PostCommentResponse;

import java.util.UUID;

public interface PostCommentService {
    PostCommentResponse createPostComment(PostCommentRequest commentRequest);

    PostCommentListResponse getPostCommentsByPostId(UUID postId);
}
