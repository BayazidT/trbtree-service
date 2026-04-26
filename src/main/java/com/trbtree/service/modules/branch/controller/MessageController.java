package com.trbtree.service.modules.branch.controller;


import com.trbtree.service.modules.branch.dto.MessageResponse;
import com.trbtree.service.modules.branch.dto.SendMessageRequest;
import com.trbtree.service.modules.branch.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/{userId}")
    public String sendMessage(@PathVariable UUID userId, @RequestBody SendMessageRequest message) {
        messageService.sendMessage(userId, message);
        return "Message sent successfully";
    }

    @GetMapping("/{conversationId}")
    public List<MessageResponse> getMessages(@PathVariable UUID conversationId) {
        List<MessageResponse> response = messageService.getMessage(conversationId);
        return response;

    }
}
