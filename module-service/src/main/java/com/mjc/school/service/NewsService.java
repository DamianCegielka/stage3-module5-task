package com.mjc.school.service;

import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;

import java.util.List;
import java.util.Set;

public interface NewsService extends BaseService<NewsDtoRequest, NewsDtoResponse,Long> {

    Set<NewsDtoResponse> readNewsByVariousParameters(NewsDtoRequest newsRequestDto);
    List<NewsDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy);
}
