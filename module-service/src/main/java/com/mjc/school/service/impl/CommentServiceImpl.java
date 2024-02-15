package com.mjc.school.service.impl;

import com.mjc.school.model.CommentModel;
import com.mjc.school.repository.CommentRepository;
import com.mjc.school.service.CommentService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.comment.CommentDtoRequest;
import com.mjc.school.service.dto.comment.CommentDtoResponse;
import com.mjc.school.service.exception.NewsDoesNotExistException;
import com.mjc.school.service.mapper.CommentDtoRequestMapperToCommentModel;
import com.mjc.school.service.mapper.CommentModelMapperToCommentDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


    private final CommentRepository repository;
    private final CommentModelMapperToCommentDtoResponse mapCommentModelToCommentDtoResponse;
    private final CommentDtoRequestMapperToCommentModel mapCommentDtoRequestToCommentModel;
    private final Validator validator;


    @Override
    public List<CommentDtoResponse> readAll() {
        return repository.findAll().stream().map(mapCommentModelToCommentDtoResponse::map).toList();
    }

    @Override
    public CommentDtoResponse readById(Long id) {
        return mapCommentModelToCommentDtoResponse
                .map(repository
                        .findById(id)
                        .orElseThrow(() -> new NewsDoesNotExistException(id)));
    }

    @Override
    public CommentDtoResponse create(CommentDtoRequest createRequest) {
        try {
            validator.lengthBetween3And15Symbols(createRequest.getContent());
            CommentModel authorModel = mapCommentDtoRequestToCommentModel.map(createRequest);
            return mapCommentModelToCommentDtoResponse.map(repository.save(authorModel));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CommentDtoResponse update(CommentDtoRequest updateRequest) {
        CommentModel commentModel = mapCommentDtoRequestToCommentModel.mapUpdate(updateRequest);
        return mapCommentModelToCommentDtoResponse.map(repository.save(commentModel));

    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CommentDtoResponse> readByNewsId(Long newsId) {
        return   repository
                .findAllByNewsModelId(newsId)
                .stream()
                .map(mapCommentModelToCommentDtoResponse::map)
                .toList();
    }

    @Override
    public List<CommentDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        String[] split = sortBy.split("::");
        return repository
                .findAll(PageRequest
                        .of(page - 1,
                                size,
                                split[1].equals("asc") ? Sort.by(split[0]).ascending() : Sort.by(split[0]).descending()))
                .getContent()
                .stream()
                .map(mapCommentModelToCommentDtoResponse::map)
                .toList();
    }

}
