package com.mjc.school.service.mapper;

import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE /*,uses = NewsMapper.class*/)
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagDtoResponse tagModelToDto(TagModel tagModel);

    @Mapping(target = "newsModels", ignore = true)
    TagModel tagDtoToModel(TagDtoRequest tagDtoRequest);
}