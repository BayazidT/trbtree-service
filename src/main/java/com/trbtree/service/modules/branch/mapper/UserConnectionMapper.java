package com.trbtree.service.modules.branch.mapper;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.dto.SendConnectionRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.UserConnection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConnectionMapper {
    UserConnection toEntity(SendConnectionRequest dto);
    @Mapping(source = "requester.id", target = "requesterId")
    @Mapping(source = "addressee.id", target = "addresseeId")

    @Mapping(source = "requester.name", target = "requesterName")
    @Mapping(source = "addressee.name", target = "addresseeName")

    @Mapping(source = "status", target = "status")
    ConnectionResponse toDTO(UserConnection entity);

    List<ConnectionResponse> toDTOList(List<UserConnection> entities);
}
