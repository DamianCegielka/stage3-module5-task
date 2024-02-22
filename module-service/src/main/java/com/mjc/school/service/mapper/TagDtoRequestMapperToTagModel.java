package com.mjc.school.service.mapper;

import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.tag.TagDtoRequest;


public interface TagDtoRequestMapperToTagModel {

    TagModel tagDtoToModel(TagDtoRequest tagDtoRequest);
}
