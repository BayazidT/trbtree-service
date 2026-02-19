package com.trbtree.service.modules.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String username,
        String displayName,
        String email,
        String bio,
        String profileUrl,
        String location,
        String websiteUrl,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Set<String> roles,           // just role names/codes
        Set<String> permissions      // optional: flattened permissions
) {}