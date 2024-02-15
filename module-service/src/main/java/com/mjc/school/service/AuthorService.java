package com.mjc.school.service;

import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;

import java.util.List;

public interface AuthorService extends BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {

    AuthorDtoResponse readByNewsId(Long newsId);

    List<AuthorDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy);
}

