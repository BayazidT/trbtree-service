package com.trbtree.service.modules.branch.service.impl;

import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.dto.SendMessageRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.Message;
import com.trbtree.service.modules.branch.mapper.MessageMapper;
import com.trbtree.service.modules.branch.repository.MessageRepository;
import com.trbtree.service.modules.branch.service.MessageService;
import com.trbtree.service.modules.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;
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

    @Override
    public List<MessageResponse> updateMessage(SendMessageRequest request, UUID messageId) {
        Message messageEntity = messageMapper.toEntity(request);
        Conversation conversation = new Conversation();
        conversation.setId(request.getConversationId());
        messageEntity.setConversation(conversation);
        User user = new User();
        user.setId(request.getReceiverId());
        messageEntity.setSender(user);
        Message oldMessage = messageRepository.findById(messageId).orElse(null);
        if (oldMessage != null) {
            messageRepository.delete(oldMessage);
        }
        messageRepository.save(messageEntity);
        return getMessage(request.getConversationId());
    }

    @Override
    public void deleteMessage(UUID messageId) {
        Message messageEntity = messageRepository.findById(messageId).orElse(null);
        messageEntity.setDeletedAt(Instant.now());
        messageRepository.save(messageEntity);
    }


    @Override
    public List<MessageResponse> getMessage(UUID conversationId) {
        List<Message> messages = messageRepository.findByConversationId(conversationId);
        return messageMapper.toDTOList(messages);
    }
}
