package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.entity.UserProfile;
import com.trbtree.service.security.auth.dto.UserProfileResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

    private UserProfileMapper() {
        // prevent instantiation
    }

    public static ProfileResponse toResponse(UserProfile entity) {
        if (entity == null) {
            return null;
        }

        return ProfileResponse.builder()
                .userId(entity.getUserId())
                .headline(entity.getHeadline())
                .currentDesignation(entity.getCurrentDesignation())
                .profilePictureUrl(entity.getProfilePictureUrl())
                .introduction(entity.getIntroduction())
                .openToWork(entity.isOpenToWork())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .linkedinUrl(entity.getLinkedinUrl())
                .githubUrl(entity.getGithubUrl())
                .isPublic(entity.isPublic())
                .lastUpdatedAt(entity.getLastUpdatedAt())
                .build();
    }
}