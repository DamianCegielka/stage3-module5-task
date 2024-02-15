package com.mjc.school.service.mapper;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorDtoRequestMapperToAuthorModel {
    AuthorModel map(AuthorDtoRequest authorDtoRequest);
}
