package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import com.trbtree.service.modules.protfolio.dto.HobbyRequest;
import com.trbtree.service.modules.protfolio.dto.HobbyResponse;
import com.trbtree.service.modules.protfolio.entity.Certification;
import com.trbtree.service.modules.protfolio.entity.Hobby;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HobbyMapper {
    Hobby toEntity(HobbyRequest dto);
    HobbyResponse toDTO(Hobby entity);
}
