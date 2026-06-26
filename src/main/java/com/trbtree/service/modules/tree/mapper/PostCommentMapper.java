package com.trbtree.service.modules.tree.mapper;

import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.dto.SendMessageRequest;
import com.trbtree.service.modules.branch.entity.Message;
import com.trbtree.service.modules.tree.dto.PostCommentRequest;
import com.trbtree.service.modules.tree.dto.PostCommentResponse;
import com.trbtree.service.modules.tree.entity.PostComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostCommentMapper {

    @Mapping(source = "postId", target = "post.id")
    @Mapping(source = "userId", target = "user.id")
    PostComment toEntity(PostCommentRequest dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "name")
    PostCommentResponse toDTO(PostComment entity);

    List<PostCommentResponse> toDTOList(List<PostComment> entityList);
}
