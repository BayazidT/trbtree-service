package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.PublicationRequest;
import com.trbtree.service.modules.protfolio.dto.PublicationResponse;
import com.trbtree.service.modules.protfolio.entity.Publication;
import com.trbtree.service.modules.protfolio.mapper.PublicationMapper;
import com.trbtree.service.modules.protfolio.repository.PublicationRepository;
import com.trbtree.service.modules.protfolio.service.PublicationService;
import lombok.RequiredArgsConstructor;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;

    @Override
    public PublicationResponse addPublication(PublicationRequest publicationRequest, UUID userId) {
        Publication publication = publicationMapper.toEntity(publicationRequest);
        publication.setUserId(userId);
        return publicationMapper.toDTO(publicationRepository.save(publication));
    }

    @Override
    public List<PublicationResponse> getPublications(UUID userId) {
        return Optional.ofNullable(publicationRepository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(publicationMapper::toDTO)
                .toList();
    }
}
