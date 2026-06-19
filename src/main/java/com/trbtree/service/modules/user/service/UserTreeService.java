package com.trbtree.service.modules.user.service;

import com.trbtree.service.modules.user.dto.UserListResponse;

import java.util.UUID;

public interface UserTreeService {
    UserListResponse getUserTree(UUID userId, int page, int size);
}
