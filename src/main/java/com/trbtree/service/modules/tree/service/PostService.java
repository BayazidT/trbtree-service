package com.trbtree.service.modules.tree.service;

import com.trbtree.service.modules.tree.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PostService {
    PostResponse createPost(UUID userId, PostRequest postRequest);

    PostListResponse getPostsOfAUser(UUID userId);
    PostListResponse getPosts();

    PostResponse getPostById(UUID id);

    PostResponse updateLikeCount(UUID id, UUID userId);

}
