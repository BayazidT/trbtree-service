package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.BioDataRequest;
import com.trbtree.service.modules.protfolio.dto.BioDataResponse;
import com.trbtree.service.modules.protfolio.entity.BioData;
import com.trbtree.service.modules.protfolio.mapper.BioDataMapper;
import com.trbtree.service.modules.protfolio.repository.BioDataRepository;
import com.trbtree.service.modules.protfolio.service.BioDataService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BioDataServiceImpl implements BioDataService {
    private final BioDataMapper bioDataMapper;
    private final BioDataRepository bioDataRepository;

    @Override
    public BioDataResponse updateBioData(UUID userId, BioDataRequest request) {
        BioData bioData = bioDataRepository.findByUserId(userId);
        bioDataRepository.delete(bioData);
        BioData newBioData = bioDataMapper.toEntity(request);
        newBioData.setUserId(userId);
        return bioDataMapper.toDTO(bioDataRepository.save(newBioData));
    }

    @Override
    public void deleteBioData(UUID userId) {
        BioData bioData = bioDataRepository.findByUserId(userId);
        bioDataRepository.delete(bioData);
    }


    @Override
    public BioDataResponse createBioData(UUID userId, BioDataRequest request) {
        BioData bioData = bioDataMapper.toEntity(request);
        bioData.setUserId(userId);
        return bioDataMapper.toDTO(bioDataRepository.save(bioData));
    }

    @Override
    public BioDataResponse getBioData(UUID userId) {
        BioData bioData = bioDataRepository.findByUserId(userId);
        return bioDataMapper.toDTO(bioData);
    }
}
