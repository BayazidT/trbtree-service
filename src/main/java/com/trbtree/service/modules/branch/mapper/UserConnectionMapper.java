package com.trbtree.service.modules.branch.mapper;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.dto.SendConnectionRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.UserConnection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConnectionMapper {
    UserConnection toEntity(SendConnectionRequest dto);
    ConnectionResponse toDTO(UserConnection entity);

    List<ConnectionResponse> toDTOList(List<UserConnection> connections);
}
