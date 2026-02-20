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

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void setUserRole(UUID userId, UUID roleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findRoleById(roleId);  // ← assuming this can return null!

        // ← Add null check here – very common cause of NPE later
        if (role == null) {
            throw new RuntimeException("Role not found with id: " + roleId);
        }

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setAssignedAt(LocalDateTime.now());

        try {
            userRoleRepository.save(userRole);
            // Optional: log success
            // log.info("Assigned role {} to user {}", roleId, userId);
        } catch (Exception e) {
            // This will show up in logs even if higher layers swallow it
            log.error("Failed to save UserRole (user={}, role={})");
            throw e;  // rethrow so controller advice / default handling still sees it
        }
    }

}
