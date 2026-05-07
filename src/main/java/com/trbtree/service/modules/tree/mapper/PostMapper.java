package com.trbtree.service.modules.tree.mapper;

import com.trbtree.service.modules.tree.dto.PostResponse;
import com.trbtree.service.modules.tree.entity.Post;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostMapper {

    public static PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getUsername(),
                post.getContent(),
                post.getVisibility().name(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
}
