package com.trbtree.service.modules.branch.service;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.SendConnectionRequest;

import java.util.List;
import java.util.UUID;

public interface ConnectionService {
    List<ConnectionResponse> getConnections(UUID userId);

    ConnectionResponse addConnection(SendConnectionRequest request, UUID userId);

    void deleteConnection(UUID connectionId);
}
