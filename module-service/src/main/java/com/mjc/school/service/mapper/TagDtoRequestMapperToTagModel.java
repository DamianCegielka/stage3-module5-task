package com.mjc.school.service.mapper;

import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TagDtoRequestMapperToTagModel {

    TagModel tagDtoToModel(TagDtoRequest tagDtoRequest);
}
