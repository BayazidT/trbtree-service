package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.BioDataRequest;
import com.trbtree.service.modules.protfolio.dto.BioDataResponse;
import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import com.trbtree.service.modules.protfolio.entity.BioData;
import com.trbtree.service.modules.protfolio.entity.Certification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BioDataMapper {
    BioData toEntity(BioDataRequest dto);
    BioDataResponse toDTO(BioData entity);
}
