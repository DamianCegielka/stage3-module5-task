package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseRestController;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/news", consumes = {"application/JSON"}, produces = {"application/JSON"})
@AllArgsConstructor
public class NewsController implements BaseRestController<NewsDtoRequest, NewsDtoResponse, Long> {

    public final NewsService service;

    @Override
    @GetMapping
    @ApiOperation(value = "View all news", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all news"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
    public ResponseEntity<List<NewsDtoResponse>> readAllByPage(
            @Min(1)
            @RequestParam int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort_by", required = false, defaultValue = "name::asc") String sortBy) {
        return new ResponseEntity<>(service.readAllPagedAndSorted(page, size, sortBy), HttpStatus.valueOf(200));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<NewsDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.readById(id), HttpStatus.valueOf(200));
    }

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NewsDtoResponse> create(@RequestBody NewsDtoRequest createRequest) {
        return new ResponseEntity<>(service.create(createRequest), HttpStatus.valueOf(201));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<NewsDtoResponse> update(@PathVariable Long id,
                                                  @RequestBody NewsDtoRequest updateRequest) {
        return new ResponseEntity<>(service.update(updateRequest), HttpStatus.valueOf(200));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
