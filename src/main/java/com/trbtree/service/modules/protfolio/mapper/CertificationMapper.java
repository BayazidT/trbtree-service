package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import com.trbtree.service.modules.protfolio.dto.ProjectRequest;
import com.trbtree.service.modules.protfolio.dto.ProjectResponse;
import com.trbtree.service.modules.protfolio.entity.Certification;
import com.trbtree.service.modules.protfolio.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
    Certification toEntity(CertificationRequest dto);
    CertificationResponse toDTO(Certification entity);
}
