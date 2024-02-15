package com.mjc.school.service.impl;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.repository.AuthorRepository;
import com.mjc.school.service.AuthorService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import com.mjc.school.service.exception.NewsDoesNotExistException;
import com.mjc.school.service.mapper.AuthorDtoRequestMapperToAuthorModel;
import com.mjc.school.service.mapper.AuthorModelMapperToAuthorDtoResponse;
import com.mjc.school.service.mapper.ModelDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorModelMapperToAuthorDtoResponse mapAuthorModelToAuthorDtoResponse;
    private final AuthorDtoRequestMapperToAuthorModel mapAuthorDtoRequestToAuthorModel;
    private final Validator validator;


    @Override
    public List<AuthorDtoResponse> readAll() {
        return repository.findAll().stream().map(mapAuthorModelToAuthorDtoResponse::map).toList();
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        return mapAuthorModelToAuthorDtoResponse
                .map(repository
                        .findById(id)
                        .orElseThrow(() -> new NewsDoesNotExistException(id)));
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        try{
            validator.lengthBetween3And15Symbols(createRequest.getName());
            AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.map(createRequest);
            return mapAuthorModelToAuthorDtoResponse.map(repository.save(authorModel));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.map(updateRequest);
        return mapAuthorModelToAuthorDtoResponse.map(repository.save(authorModel));

    }

    @Override
    public boolean deleteById(Long id) {
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public AuthorDtoResponse readByNewsId(Long newsId) {
        return mapAuthorModelToAuthorDtoResponse.map(repository.findAllByNewsModelId(newsId));
    }

    @Override
    public List<AuthorDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        String[] split = sortBy.split("::");
        return repository
                .findAll(PageRequest
                        .of(page - 1,
                                size,
                                split[1].equals("asc") ? Sort.by(split[0]).ascending() : Sort.by(split[0]).descending()))
                .getContent()
                .stream()
                .map(mapAuthorModelToAuthorDtoResponse::map)
                .toList();
    }
}
