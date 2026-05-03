package com.trbtree.service.modules.branch.service.impl;

import com.trbtree.service.modules.branch.dto.ConnectionResponse;
import com.trbtree.service.modules.branch.dto.ConnectionUpdateRequest;
import com.trbtree.service.modules.branch.dto.SendConnectionRequest;
import com.trbtree.service.modules.branch.entity.UserConnection;
import com.trbtree.service.modules.branch.enums.ConnectionStatus;
import com.trbtree.service.modules.branch.mapper.UserConnectionMapper;
import com.trbtree.service.modules.branch.repository.ConnectionRepository;
import com.trbtree.service.modules.branch.service.ConnectionService;
import com.trbtree.service.modules.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {
    private final ConnectionRepository connectionRepository;
    private final UserConnectionMapper userConnectionMapper;

    @Override
    public List<ConnectionResponse> getConnections(UUID userId) {
        List<UserConnection> connections = connectionRepository.findByAddresseeId(userId);
        return userConnectionMapper.toDTOList(connections);
    }

    @Override
    public void deleteConnection(UUID connectionId) {
        connectionRepository.deleteById(connectionId);
    }

    @Override
    public ConnectionResponse addConnection(SendConnectionRequest request, UUID userId) {
        UserConnection userConnection = userConnectionMapper.toEntity(request);
        User user = new User();
        user.setId(userId);
        userConnection.setRequester(user);
        User addresse= new User();
        addresse.setId(request.getAddresseeId());
        userConnection.setAddressee(addresse);
        userConnection.setStatus(ConnectionStatus.PENDING);
        UserConnection response = connectionRepository.save(userConnection);
        return userConnectionMapper.toDTO(response);
    }

    @Override
    public List<ConnectionResponse> update(UUID connectionId, ConnectionUpdateRequest request) {
        UserConnection connection =connectionRepository.findById(connectionId).orElseThrow();
        connection.setStatus(request.getStatus());
        connectionRepository.save(connection);
        return getConnections(connection.getAddressee().getId());
    }
}
