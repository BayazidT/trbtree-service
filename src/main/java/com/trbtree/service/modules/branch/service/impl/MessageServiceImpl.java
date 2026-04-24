package com.trbtree.service.modules.branch.service.impl;

import com.trbtree.service.modules.branch.dto.SendMessageRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.Message;
import com.trbtree.service.modules.branch.mapper.MessageMapper;
import com.trbtree.service.modules.branch.repository.MessageRepository;
import com.trbtree.service.modules.branch.service.MessageService;
import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public void sendMessage(UUID userId, SendMessageRequest message) {
        Message messageEntity = messageMapper.toEntity(message);
        Conversation conversation = new Conversation();
        conversation.setId(message.getConversationId());
        User user = new User();
        user.setId(userId);
        messageEntity.setSender(user);
        messageEntity.setConversation(conversation);
        messageRepository.save(messageEntity);
    }
}
