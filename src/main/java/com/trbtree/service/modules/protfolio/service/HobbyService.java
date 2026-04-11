package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.HobbyRequest;
import com.trbtree.service.modules.protfolio.dto.HobbyResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HobbyService {
    List<HobbyResponse> getHobbies(UUID userId);

    HobbyResponse addHobby(HobbyRequest hobbyRequest, UUID userId);
}
