package com.trbtree.service.modules.user.mapper;

import com.trbtree.service.modules.user.dto.UserRequest;
import com.trbtree.service.modules.user.dto.UserResponse;
import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.rbac.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    /**
     * Maps UserRequest → User entity (for registration / creation)
     */
    public User toEntity(UserRequest request) {
        return User.builder()
                .displayName(request.displayName())
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))  // Always encode – no fallback!
                .active(true)
                // Optional: if you want to assign a default role during creation
                // .roles(Set.of(defaultUserRole))  // you can inject or fetch Role service
                .build();
    }

    /**
     * Maps User entity → UserResponse (safe DTO – no sensitive data)
     */
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .displayName(user.getDisplayName())
                .email(user.getEmail())
                .bio(user.getBio())
                .avatarUrl(user.getAvatarUrl())
                .location(user.getLocation())
                .website(user.getWebsite())
                .active(user.isActive())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                // Optional: include role names (and permissions if needed)
                .roles(user.getRoles().stream()
                        .map(Role::getName)           // or getCode() if you prefer
                        .collect(Collectors.toSet()))
                // .permissions(...) if you want flattened permission codes
                .build();
    }

    /**
     * Updates existing User entity from UserUpdateRequest or UserRequest (PATCH/PUT)
     * Only updates provided (non-null) fields
     */
    public void updateEntity(User user, UserRequest request) {
        // For full update (PUT) – or use UserUpdateRequest for partial (PATCH)
        if (request.displayName() != null) {
            user.setDisplayName(request.displayName());
        }
        if (request.username() != null) {
            user.setUsername(request.username());
        }
        if (request.email() != null) {
            user.setEmail(request.email());
        }
        if (request.password() != null && !request.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.password()));
        }

        // If you later add more fields to UserRequest (bio, avatar, etc.)
        // you can extend this method or create a separate updateFromUpdateRequest(...)
    }

    /**
     * Optional: dedicated method for partial updates (PATCH)
     * Use when you have a separate UserUpdateRequest DTO without password/username
     */
    // public void updateFromPatch(User user, UserUpdateRequest request) {
    //     if (request.displayName() != null) user.setDisplayName(request.displayName());
    //     if (request.bio() != null) user.setBio(request.bio());
    //     if (request.avatarUrl() != null) user.setAvatarUrl(request.avatarUrl());
    //     if (request.location() != null) user.setLocation(request.location());
    //     if (request.website() != null) user.setWebsite(request.website());
    //     if (request.email() != null) user.setEmail(request.email());
    //     // Note: password change should be separate endpoint with old password verification
    // }
}