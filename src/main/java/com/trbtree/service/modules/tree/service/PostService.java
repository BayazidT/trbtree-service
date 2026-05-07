package com.trbtree.service.modules.tree.service;

import com.trbtree.service.modules.tree.dto.PostListResponse;
import com.trbtree.service.modules.tree.dto.PostRequest;
import com.trbtree.service.modules.tree.dto.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PostService {
    PostResponse createPost(UUID userId, PostRequest postRequest);

    PostListResponse getPosts(UUID userId);
}
