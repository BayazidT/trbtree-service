package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.entity.UserProfile;
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
                .headline(entity.getHeadline())
                .currentDesignation(entity.getCurrentDesignation())
                .profilePictureUrl(entity.getProfilePictureUrl())
                .introduction(entity.getIntroduction())
                .openToWork(entity.isOpenToWork())
                .displayEmail(entity.getEmail())
                .displayPhone(entity.getPhone())
                .linkedinUrl(entity.getLinkedinUrl())
                .githubUrl(entity.getGithubUrl())
                .isPublic(entity.isPublic())
                .lastUpdatedAt(entity.getLastUpdatedAt())
                .build();
    }

    public UserProfile updateProfile(UserProfile userProfile, ProfileRequest request) {
        userProfile.setHeadline(request.getHeadline());
        userProfile.setCurrentDesignation(request.getCurrentDesignation());
        userProfile.setProfilePictureUrl(request.getProfilePictureUrl());
        userProfile.setIntroduction(request.getIntroduction());
        userProfile.setOpenToWork(request.isOpenToWork());
        userProfile.setEmail(request.getDisplayEmail());
        userProfile.setPhone(request.getDisplayPhone());
        userProfile.setLinkedinUrl(request.getLinkedinUrl());
        userProfile.setGithubUrl(request.getGithubUrl());
        userProfile.setPublic(request.isPublic());
        return userProfile;
    }
}