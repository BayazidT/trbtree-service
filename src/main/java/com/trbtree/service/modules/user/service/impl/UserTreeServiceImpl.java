package com.trbtree.service.modules.user.service.impl;

import com.trbtree.service.modules.branch.entity.UserConnection;
import com.trbtree.service.modules.branch.repository.ConnectionRepository;
import com.trbtree.service.modules.user.dto.UserListResponse;
import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.modules.user.mapper.UserMapper;
import com.trbtree.service.modules.user.repository.UserRepository;
import com.trbtree.service.modules.user.service.UserService;
import com.trbtree.service.modules.user.service.UserTreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserTreeServiceImpl implements UserTreeService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ConnectionRepository connectionRepository;

    @Override
    public UserListResponse getUserTree(UUID userId, int page, int size) {
        List<UserConnection> userTreeExcept = connectionRepository.findUserTreeExcept(userId);

        List<UUID> exceptIds = new ArrayList<>();
        for (UserConnection userConnection : userTreeExcept) {
            if(!userConnection.getAddressee().getId().equals(userId)){
                exceptIds.add(userConnection.getAddressee().getId());
            }
            if(!userConnection.getRequester().getId().equals(userId)){
                exceptIds.add(userConnection.getAddressee().getId());
            }
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> userResponses=  userRepository.findAll(pageable);
        List<User> users = userResponses.getContent();
        List<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            if(!exceptIds.contains(user.getId()) && !user.getId().equals(userId)){
                filteredUsers.add(user);
            }
        }
        return new UserListResponse(
                filteredUsers.stream()
                        .map(userMapper::toResponse)
                        .toList(),
                userResponses.getTotalElements(),
                userResponses.getTotalPages(),
                userResponses.getNumber(),
                userResponses.getSize(),
                userResponses.isFirst(),
                userResponses.isLast()
        );
    }
}
