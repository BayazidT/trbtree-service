package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.BioDataRequest;
import com.trbtree.service.modules.protfolio.dto.BioDataResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BioDataService {
    BioDataResponse getBioData(UUID userId);

    BioDataResponse createBioData(UUID userId, BioDataRequest request);
}
