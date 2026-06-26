package com.trbtree.service.modules.tree.service.impl;

import com.trbtree.service.modules.tree.dto.PostCommentListResponse;
import com.trbtree.service.modules.tree.dto.PostCommentRequest;
import com.trbtree.service.modules.tree.dto.PostCommentResponse;
import com.trbtree.service.modules.tree.entity.Post;
import com.trbtree.service.modules.tree.entity.PostComment;
import com.trbtree.service.modules.tree.mapper.PostCommentMapper;
import com.trbtree.service.modules.tree.repository.PostCommentRepository;
import com.trbtree.service.modules.tree.repository.PostRepository;
import com.trbtree.service.modules.tree.service.PostCommentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository repository;
    private final PostCommentMapper postCommentMapper;
    private final PostRepository postRepository;

    @Override
    public PostCommentResponse createPostComment(PostCommentRequest commentRequest) {
        PostComment postComment = postCommentMapper.toEntity(commentRequest);
        PostComment saved = repository.save(postComment);
        Post post = postRepository.findById(commentRequest.getPostId()).orElse(null);
        if (post != null) {
            post.setCommentCount(post.getCommentCount() + 1);
            postRepository.save(post);
        }
        return postCommentMapper.toDTO(saved);
    }

    @Override
    public PostCommentListResponse getPostCommentsByPostId(UUID postId) {
        List<PostComment> commentList = repository.findByPostId(postId);
        return PostCommentListResponse.builder()
                .content(postCommentMapper.toDTOList(commentList))
                .build();
    }
}
