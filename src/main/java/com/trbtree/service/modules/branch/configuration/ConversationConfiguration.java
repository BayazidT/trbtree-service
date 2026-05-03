package com.trbtree.service.modules.branch.configuration;

import com.trbtree.service.modules.branch.repository.ConversationParticipantRepository;
import com.trbtree.service.modules.branch.repository.ConversationRepository;
import com.trbtree.service.modules.branch.service.ConversationService;
import com.trbtree.service.modules.branch.service.MessageService;
import com.trbtree.service.modules.branch.service.impl.ConversationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConversationConfiguration {
    private final ConversationRepository conversationRepository;
    private final ConversationParticipantRepository participantRepository;
    private final MessageService messageService;

    @Bean
    public ConversationService getConversationServiceImpl(){
        return new ConversationServiceImpl(conversationRepository, participantRepository, messageService);
    }
}
