package com.trbtree.service.modules.branch.controller;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.ConnectionResponseList;
import com.trbtree.service.modules.branch.dto.ConnectionUpdateRequest;
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
    public ConnectionResponseList getConnectionsReceived(@PathVariable UUID userId) {
        List<ConnectionResponse> connectionResponses = connectionService.getConnections(userId);
        ConnectionResponseList connectionResponseList = new ConnectionResponseList();
        connectionResponseList.setConnections(connectionResponses);
        return connectionResponseList;
    }
    @GetMapping("sent/{userId}")
    public ConnectionResponseList getConnectionsSent(@PathVariable UUID userId) {
        List<ConnectionResponse> connectionResponses = connectionService.getConnections(userId);
        ConnectionResponseList connectionResponseList = new ConnectionResponseList();
        connectionResponseList.setConnections(connectionResponses);
        return connectionResponseList;
    }

    @PostMapping("/{userId}")
    public ConnectionResponse addConnection(@PathVariable UUID userId, @RequestBody SendConnectionRequest request) {
        ConnectionResponse response =connectionService.addConnection(request, userId);
        return response;
    }

    @PutMapping("/{connectionId}")
    public ConnectionResponseList updateConnection(@PathVariable UUID connectionId, @RequestBody ConnectionUpdateRequest request) {
        List<ConnectionResponse> connectionResponses = connectionService.update(connectionId, request);
        ConnectionResponseList connectionResponseList = new ConnectionResponseList();
        connectionResponseList.setConnections(connectionResponses);
        return connectionResponseList;
    }


    @DeleteMapping("/{connectionId}")
    public void deleteConnection(@PathVariable UUID connectionId) {
        connectionService.deleteConnection(connectionId);
    }


}
