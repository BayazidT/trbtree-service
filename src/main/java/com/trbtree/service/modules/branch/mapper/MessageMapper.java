package com.trbtree.service.modules.branch.mapper;

import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.dto.SendMessageRequest;
import com.trbtree.service.modules.branch.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toEntity(SendMessageRequest dto);
    MessageResponse toDTO(Message entity);
}
