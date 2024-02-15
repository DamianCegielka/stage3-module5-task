package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseRestController;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/tag", consumes = {"application/JSON"}, produces = {"application/JSON"})
@AllArgsConstructor
public class TagController implements BaseRestController<TagDtoRequest, TagDtoResponse, Long> {

    public final TagService service;

    @Override
    @GetMapping
    public ResponseEntity<List<TagDtoResponse>> readAllByPage(
            @Min(1)
            @RequestParam int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort_by", required = false, defaultValue = "name::asc") String sortBy) {
        return new ResponseEntity<>(service.readAllPagedAndSorted(page, size, sortBy), HttpStatus.valueOf(200));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TagDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.readById(id), HttpStatus.valueOf(200));
    }

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TagDtoResponse> create(@RequestBody TagDtoRequest createRequest) {
        return new ResponseEntity<>(service.create(createRequest), HttpStatus.valueOf(201));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<TagDtoResponse> update(@PathVariable Long id,
                                                 @RequestBody TagDtoRequest updateRequest) {
        return new ResponseEntity<>(service.update(updateRequest), HttpStatus.valueOf(200));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
