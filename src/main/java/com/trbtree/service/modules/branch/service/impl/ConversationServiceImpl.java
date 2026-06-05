package com.trbtree.service.modules.branch.service.impl;

import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.entity.Conversation;
import com.trbtree.service.modules.branch.entity.ConversationParticipant;
import com.trbtree.service.modules.branch.enums.ConversationType;
import com.trbtree.service.modules.branch.repository.ConversationParticipantRepository;
import com.trbtree.service.modules.branch.repository.ConversationRepository;
import com.trbtree.service.modules.branch.service.ConversationService;
import com.trbtree.service.modules.branch.service.MessageService;
import com.trbtree.service.modules.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {
    private final ConversationRepository conversationRepository;
    private final ConversationParticipantRepository participantRepository;
    private final MessageService messageService;

    @Override
    public Boolean checkIfConversationExist(UUID userId, UUID participantId) {
        List<UUID> conversationIds = participantRepository.checkIfConversationExist(userId, participantId);
        if (conversationIds.isEmpty()) {
            return false;
        }

        return conversationIds.stream().distinct().count() < conversationIds.size();
    }

    @Override
    public List<ConversationResponse> getConversations(UUID userId) {
        List<ConversationParticipant> conversationParticipants = participantRepository.findByUserId(userId);
        List<ConversationResponse> conversationResponses = new ArrayList<>();
        List<UUID> conversationIds = new ArrayList<>();

        for (ConversationParticipant conversationParticipant : conversationParticipants) {
            conversationIds.add(conversationParticipant.getConversation().getId());
        }
        List<ConversationParticipant> conversationParticipantListFilterList = new ArrayList<>();
        conversationIds.stream().forEach(conversationId -> {
            List<ConversationParticipant> conversationParticipantList = participantRepository.findByConversationId(conversationId);
            conversationParticipantListFilterList.addAll(conversationParticipantList);
        });
        for (ConversationParticipant conversationParticipant : conversationParticipantListFilterList) {

            if(!conversationParticipant.getUser().getId().equals(userId)) {
                ConversationResponse response = ConversationResponse
                        .builder()
                        .conversationId(conversationParticipant.getConversation().getId())
                        .otherUsername(conversationParticipant.getUser().getName())
                        .otherUserId(conversationParticipant.getUser().getId())
                        .lastMessage(getLastMessage(conversationParticipant.getConversation().getId()))
                        .build();
                conversationResponses.add(response);
            }
        }

        return conversationResponses;
    }

    private String getLastMessage(UUID id) {
        List<MessageResponse> messageResponses =  messageService.getMessage(id);
        if(messageResponses.size() > 0) {
            return messageResponses.get(messageResponses.size()-1).getContent();
        }
        return null;
    }

    @Override
    public UUID startConversation(CreateConversationRequest request, UUID userId) {
        Conversation entity = new Conversation();
        entity.setType(ConversationType.DIRECT);
        Conversation conversation = conversationRepository.save(entity);

        List<ConversationParticipant> participantList = new ArrayList<>();
        User sender = new User();
        sender.setId(userId);
        ConversationParticipant conversationCreator = new ConversationParticipant();
        conversationCreator.setConversation(conversation);
        conversationCreator.setUser(sender);
        participantList.add(conversationCreator);

//        if(!request.getParticipantIds().isEmpty()) {
//            request.getParticipantIds().forEach(conversationParticipantId -> {
//                ConversationParticipant conversationParticipant = new ConversationParticipant();
//                User user = new User();
//                user.setId(conversationParticipantId);
//
//                conversationParticipant.setConversation(conversation);
//                conversationParticipant.setUser(user);
//                participantList.add(conversationParticipant);
//            });
//        }
        User user = new User();
        user.setId(request.getParticipantId());
        ConversationParticipant conversationParticipant = new ConversationParticipant();
        conversationParticipant.setUser(user);
        conversationParticipant.setConversation(conversation);
        participantList.add(conversationParticipant);
        participantRepository.saveAll(participantList);
        return conversation.getId();
    }
}
