package com.trbtree.service.modules.branch.service.impl;

import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.ConversationParticipant;
import com.trbtree.service.modules.branch.enums.ConversationType;
import com.trbtree.service.modules.branch.repository.ConversationParticipantRepository;
import com.trbtree.service.modules.branch.repository.ConversationRepository;
import com.trbtree.service.modules.branch.service.ConversationService;
import com.trbtree.service.modules.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {
    private final ConversationRepository conversationRepository;
    private final ConversationParticipantRepository participantRepository;
    @Override
    public void startConversation(CreateConversationRequest request) {
        Conversation entity = new Conversation();
        entity.setType(ConversationType.DIRECT);
        Conversation conversation = conversationRepository.save(entity);
        List<ConversationParticipant> participantList = new ArrayList<>();

        request.getParticipantIds().forEach(conversationParticipantId -> {
            ConversationParticipant conversationParticipant = new ConversationParticipant();
            User user = new User();
            user.setId(conversationParticipantId);

            conversationParticipant.setConversation(conversation);
            conversationParticipant.setUser(user);
            participantList.add(conversationParticipant);
        });
        participantRepository.saveAll(participantList);

    }
}
