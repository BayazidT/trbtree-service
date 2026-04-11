package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.PublicationRequest;
import com.trbtree.service.modules.protfolio.dto.PublicationResponse;
import com.trbtree.service.modules.protfolio.entity.Publication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {
    Publication toEntity(PublicationRequest dto);
    PublicationResponse toDTO(Publication entity);
}
