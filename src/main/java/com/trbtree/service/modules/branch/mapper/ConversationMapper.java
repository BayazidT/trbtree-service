package com.trbtree.service.modules.branch.mapper;

import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {
    Conversation toEntity(CreateConversationRequest dto);
    ConversationResponse toDTO(Conversation entity);
}
