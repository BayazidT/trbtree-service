package com.trbtree.service.rbac.service;

import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.modules.user.repository.UserRepository;
import com.trbtree.service.rbac.entity.UserRole;
import com.trbtree.service.rbac.entity.Role;
import com.trbtree.service.rbac.repository.RoleRepository;
import com.trbtree.service.rbac.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void setUserRole(UUID userId, UUID roleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setAssignedAt(LocalDateTime.now());

        userRoleRepository.save(userRole);
    }

}
