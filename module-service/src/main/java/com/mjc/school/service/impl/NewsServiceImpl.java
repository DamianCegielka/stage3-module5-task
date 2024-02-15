package com.mjc.school.service.impl;

import com.mjc.school.model.NewsModel;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import com.mjc.school.service.exception.NewsDoesNotExistException;
import com.mjc.school.service.mapper.NewsDtoRequestMapperToNewsModel;
import com.mjc.school.service.mapper.NewsModelMapperToDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {


    private final NewsRepository repository;
    private final NewsModelMapperToDtoResponse mapNewsModelToDtoResponse;
    private final NewsDtoRequestMapperToNewsModel mapNewsDtoRequestToNewsModel;
    private final Validator validator;


    @Override
    public List<NewsDtoResponse> readAll() {
        return repository
                .findAll()
                .stream()
                .map(mapNewsModelToDtoResponse::map)
                .toList();
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return mapNewsModelToDtoResponse
                .map(repository
                        .findById(id)
                        .orElseThrow(() -> new NewsDoesNotExistException(id)));
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        try {
            validator.lengthBetween5And30Symbols(createRequest.getTitle());
            validator.lengthBetween5And255Symbols(createRequest.getContent());
            NewsModel newsModel = mapNewsDtoRequestToNewsModel.map(createRequest);
            return mapNewsModelToDtoResponse.map(repository.save(newsModel));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        NewsModel newsModel = mapNewsDtoRequestToNewsModel.mapUpdate(updateRequest);
        return mapNewsModelToDtoResponse.map(repository.save(newsModel));
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Set<NewsDtoResponse> readNewsByVariousParameters(NewsDtoRequest newsDtoRequest) {

        Set<NewsModel> searchResult = new HashSet<>();
        if (!newsDtoRequest.getTagNames().isBlank()) {
            Arrays.stream(newsDtoRequest.getTagNames().split(","))
                    .map(repository::findAllByTagModelName)
                    .forEach(searchResult::addAll);
        }
        if (!newsDtoRequest.getTagIds().isBlank()) {
            Arrays.stream(newsDtoRequest.getTagIds().split(","))
                    .map(s -> repository.findAllByTagModelId(Long.valueOf(s)))
                    .forEach(searchResult::addAll);
        }
        if (!newsDtoRequest.getAuthorName().isBlank()) {
            searchResult.addAll(repository.findAllByAuthorModelName(newsDtoRequest.getAuthorName()));
        }
        if (!newsDtoRequest.getTitle().isBlank()) {
            searchResult.addAll(repository.findAllByTitle(newsDtoRequest.getTitle()));
        }
        if (!newsDtoRequest.getContent().isBlank()) {
            searchResult.addAll(repository.findAllByContent(newsDtoRequest.getContent()));
        }
        return searchResult.stream().map(mapNewsModelToDtoResponse::map).collect(Collectors.toSet());
    }

    @Override
    public List<NewsDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        String[] split = sortBy.split("::");
        return repository
                .findAll(PageRequest
                        .of(page - 1, size, split[1].equals("asc") ? Sort.by(split[0]).ascending() : Sort.by(split[0]).descending()))
                .getContent()
                .stream()
                .map(mapNewsModelToDtoResponse::map)
                .toList();
    }
}
