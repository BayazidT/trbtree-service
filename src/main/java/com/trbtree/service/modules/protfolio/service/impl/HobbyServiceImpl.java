package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.HobbyRequest;
import com.trbtree.service.modules.protfolio.dto.HobbyResponse;
import com.trbtree.service.modules.protfolio.entity.Hobby;
import com.trbtree.service.modules.protfolio.mapper.HobbyMapper;
import com.trbtree.service.modules.protfolio.repository.HobbyRepository;
import com.trbtree.service.modules.protfolio.service.HobbyService;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository repository;
    private final HobbyMapper hobbyMapper;

    @Override
    public List<HobbyResponse> getHobbies(UUID userId) {
        return Optional.ofNullable(repository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(hobbyMapper::toDTO)
                .toList();
    }

    @Override
    public HobbyResponse updateHobby(HobbyRequest hobbyRequest, UUID id) {
        Hobby oldEntry = repository.findById(id).orElse(null);
        Hobby hobby = hobbyMapper.toEntity(hobbyRequest);
        hobby.setUserId(oldEntry.getUserId());
        repository.delete(oldEntry);
        return hobbyMapper.toDTO(repository.save(hobby));
    }

    @Override
    public HobbyResponse addHobby(HobbyRequest hobbyRequest, UUID userId) {
        Hobby hobby = hobbyMapper.toEntity(hobbyRequest);
        hobby.setUserId(userId);
        return hobbyMapper.toDTO(repository.save(hobby));
    }
}
