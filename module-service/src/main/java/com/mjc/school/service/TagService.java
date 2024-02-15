package com.mjc.school.service;

import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import java.util.List;

public interface TagService extends BaseService<TagDtoRequest, TagDtoResponse,Long> {

    List<TagDtoResponse> readByNewsId(Long newsId);
    List<TagDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy);
}
