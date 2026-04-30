package com.trbtree.service.modules.branch.controller;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.SendConnectionRequest;
import com.trbtree.service.modules.branch.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trbtree-service/api/v1/private/connection")
@RequiredArgsConstructor
public class ConnectionController {
    private final ConnectionService connectionService;

    @GetMapping("receive/{userId}")
    public List<ConnectionResponse> getConnectionsReceived(@PathVariable UUID userId) {
        List<ConnectionResponse> connectionResponses = connectionService.getConnections(userId);
        return connectionResponses;
    }
    @GetMapping("sent/{userId}")
    public List<ConnectionResponse> getConnectionsSent(@PathVariable UUID userId) {
        List<ConnectionResponse> connectionResponses = connectionService.getConnections(userId);
        return connectionResponses;
    }

    @PostMapping("/{userId}")
    public ConnectionResponse addConnection(@PathVariable UUID userId, @RequestBody SendConnectionRequest request) {
        ConnectionResponse response =connectionService.addConnection(request, userId);
        return response;
    }

    @DeleteMapping("/{connectionId}")
    public void deleteConnection(@PathVariable UUID connectionId) {
        connectionService.deleteConnection(connectionId);
    }


}
