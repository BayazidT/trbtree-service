package com.trbtree.service.modules.branch.configuration;

import com.trbtree.service.modules.branch.mapper.MessageMapper;
import com.trbtree.service.modules.branch.repository.MessageRepository;
import com.trbtree.service.modules.branch.service.MessageService;
import com.trbtree.service.modules.branch.service.impl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageConfiguration {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Bean
    public MessageService getMessageService() {
        return new MessageServiceImpl(messageRepository, messageMapper);
    }
}
