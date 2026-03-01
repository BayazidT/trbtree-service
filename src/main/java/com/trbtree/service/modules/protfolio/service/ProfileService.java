package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.exception.DataNotFoundException;
import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.entity.UserProfile;
import com.trbtree.service.modules.protfolio.mapper.UserProfileMapper;
import com.trbtree.service.modules.protfolio.repository.ProfileRepository;
import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
    private final UserProfileMapper userProfileMapper;
    public ProfileResponse getProfile(UUID userId) {
        UserProfile userProfile = repository.findByUserId(userId).orElseThrow(() -> new DataNotFoundException("User not found"));
        return userProfileMapper.toResponse(userProfile);
    }

    public ProfileResponse updateProfile(UUID userId, ProfileRequest request) {
        return null;
    }
}
