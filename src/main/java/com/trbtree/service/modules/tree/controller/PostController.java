package com.trbtree.service.modules.tree.controller;


import com.trbtree.service.modules.tree.dto.PostListResponse;
import com.trbtree.service.modules.tree.dto.PostRequest;
import com.trbtree.service.modules.tree.dto.PostResponse;
import com.trbtree.service.modules.tree.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public PostResponse createPost(@PathVariable UUID userId, @RequestBody PostRequest postRequest) {
        PostResponse response = postService.createPost(userId, postRequest);
        return response;
    }

    @GetMapping("/{userId}")
    public PostListResponse getPostsOfAUser(@PathVariable UUID userId) {
        PostListResponse responses = postService.getPostsOfAUser(userId);

        return responses;
    }

    @GetMapping("/")
    public PostListResponse getPosts() {
        PostListResponse responses = postService.getPosts();
        return responses;
    }


}
