package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.PublicationRequest;
import com.trbtree.service.modules.protfolio.dto.PublicationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PublicationService {
    List<PublicationResponse> getPublications(UUID userId);

    PublicationResponse addPublication(PublicationRequest publicationRequest, UUID userId);
}
