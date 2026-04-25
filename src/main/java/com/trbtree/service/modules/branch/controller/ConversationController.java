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
    public String startConversation(@Valid @RequestBody CreateConversationRequest request, @PathVariable String userId) {
        conversationService.startConversation(request);
        return "Conversation started!";
    }
     @GetMapping("/{userId}")
    public List<ConversationResponse> getConversation(@PathVariable UUID userId){
        List<ConversationResponse> responses = conversationService.getConversations(userId);
        return responses;
     }

}
