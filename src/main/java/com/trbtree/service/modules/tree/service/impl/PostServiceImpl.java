package com.trbtree.service.modules.tree.service.impl;

import com.trbtree.service.modules.tree.dto.PostListResponse;
import com.trbtree.service.modules.tree.dto.PostRequest;
import com.trbtree.service.modules.tree.dto.PostResponse;
import com.trbtree.service.modules.tree.entity.Post;
import com.trbtree.service.modules.tree.entity.PostLike;
import com.trbtree.service.modules.tree.mapper.PostMapper;
import com.trbtree.service.modules.tree.repository.PostLikeRepository;
import com.trbtree.service.modules.tree.repository.PostRepository;
import com.trbtree.service.modules.tree.service.PostService;
import com.trbtree.service.modules.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PostLikeRepository postLikeRepository;

    @Override
    public PostListResponse getPostsOfAUser(UUID userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = postMapper.toResponse(post);
            postResponses.add(postResponse);
        }
        return PostListResponse.builder()
                .content(postResponses)
                .build();
    }

    @Override
    public PostListResponse getPosts() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = postMapper.toResponse(post);
            postResponses.add(postResponse);
        }
        return PostListResponse.builder()
                .content(postResponses)
                .build();
    }

    @Override
    public PostResponse createPost(UUID userId, PostRequest postRequest) {
        Post post = postMapper.toEntity(postRequest);
        User user = new User();
        user.setId(userId);
        post.setUser(user);
        return postMapper.toResponse(postRepository.save(post));
    }

    @Override
    public PostResponse getPostById(UUID id) {
        Post post = postRepository.findById(id).orElse(null);
        return postMapper.toResponse(post);
    }

    @Override
    public PostResponse updateLikeCount(UUID id, UUID userId) {
        Post post = postRepository.findById(id).orElse(null);
        User user = new User();
        user.setId(userId);

        PostLike postLike = new PostLike();
        postLike.setPost(post);
        postLike.setUser(user);
        postLikeRepository.save(postLike);

        post.setLikeCount(post.getLikeCount() + 1);
        postRepository.save(post);
        return postMapper.toResponse(post);
    }
}
