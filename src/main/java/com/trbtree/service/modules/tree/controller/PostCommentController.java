package com.trbtree.service.modules.tree.controller;


import com.trbtree.service.modules.tree.dto.*;
import com.trbtree.service.modules.tree.service.PostCommentService;
import com.trbtree.service.modules.tree.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/post/comment")
@RequiredArgsConstructor
public class PostCommentController {
    private final PostCommentService commentService;


    @PostMapping("/")
    public PostCommentResponse createPostComment(@RequestBody PostCommentRequest commentRequest) {
        PostCommentResponse response = commentService.createPostComment(commentRequest);
        return response;
    }

    @GetMapping("/post/{postId}")
    public PostCommentListResponse getPostCommentsByPostId(@PathVariable UUID postId) {
        PostCommentListResponse response = commentService.getPostCommentsByPostId(postId);
        return response;
    }
//
//    @PatchMapping("/{id}/{userId}")
//    public PostResponse updateLikeCount(@PathVariable UUID id, @PathVariable UUID userId) {
//        PostResponse response = commentService.updateLikeCount(id, userId);
//        return response;
//    }
//

}
