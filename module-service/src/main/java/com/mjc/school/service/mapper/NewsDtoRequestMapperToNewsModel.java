package com.mjc.school.service.mapper;

import com.mjc.school.model.NewsModel;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface NewsDtoRequestMapperToNewsModel {

    NewsModel map(NewsDtoRequest request);

    NewsModel mapUpdate(NewsDtoRequest request);
}
