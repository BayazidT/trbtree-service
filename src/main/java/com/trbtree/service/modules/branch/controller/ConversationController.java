package com.trbtree.service.modules.branch.controller;


import com.trbtree.service.modules.branch.dto.ConversationResponse;
import com.trbtree.service.modules.branch.dto.CreateConversationRequest;
import com.trbtree.service.modules.branch.service.ConversationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/conversation")
@RequiredArgsConstructor
public class ConversationController {
    private final ConversationService conversationService;

    @PostMapping("/{userId}")
    public UUID startConversation(@Valid @RequestBody CreateConversationRequest request, @PathVariable UUID userId) {
        UUID conversationId = conversationService.startConversation(request, userId);
        return conversationId;
    }
     @GetMapping("/{userId}")
    public List<ConversationResponse> getConversation(@PathVariable UUID userId){
        List<ConversationResponse> responses = conversationService.getConversations(userId);
        return responses;
     }

     @GetMapping("/{userId}/{participantId}")
    public Boolean getIfConversationExist(@PathVariable UUID userId, @PathVariable UUID participantId) {
        Boolean response = conversationService.checkIfConversationExist(userId, participantId);
        return response;
     }

}
