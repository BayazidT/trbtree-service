package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService {
    public Object getProfile(UUID userId) {
        return null;
    }

    public ProfileResponse updateProfile(UUID userId, ProfileRequest request) {
        return null;
    }
}
