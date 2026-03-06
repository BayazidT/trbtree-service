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
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
    private final UserRepository userRepository;
    private final UserProfileMapper userProfileMapper;
    public ProfileResponse getProfile(UUID userId) {
        UserProfile userProfile = repository.findByUserId(userId).orElseThrow(() -> new DataNotFoundException("User not found"));
        return userProfileMapper.toResponse(userProfile);
    }

    public ProfileResponse getOrCreateProfile(UUID userId) {
        return userProfileMapper.toResponse(repository.findByUserId(userId)
                .orElseGet(() -> {
                    User user = userRepository.getReferenceById(userId); // or findById().orElseThrow()
                    UserProfile newProfile = new UserProfile();
                    newProfile.setUser(user);
                    newProfile.setHeadline("New User");
                    newProfile.setOpenToWork(false);
                    UserProfile userProfile = repository.save(newProfile);
                    return userProfile;
                }));
    }
    public ProfileResponse updateProfile(UUID userId, ProfileRequest request) {
        return null;
    }
}
