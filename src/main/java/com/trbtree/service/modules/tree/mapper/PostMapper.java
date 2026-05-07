package com.trbtree.service.modules.tree.mapper;

import com.trbtree.service.modules.tree.dto.PostRequest;
import com.trbtree.service.modules.tree.dto.PostResponse;
import com.trbtree.service.modules.tree.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostMapper {

    public static PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getName(),
                post.getContent(),
                post.getVisibility().name(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
    public static Post toEntity(PostRequest postRequest) {
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setVisibility(postRequest.getVisibility());
        return post;
    }
}
