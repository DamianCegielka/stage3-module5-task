package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseRestController;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tag", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(produces = "application/json", value = "Operations for creating, updating, retrieving and deleting tags in the application")
@RequiredArgsConstructor
public class TagController implements BaseRestController<TagDtoRequest, TagDtoResponse, Long> {

    public final TagService service;

    @Override
    @GetMapping
    @ApiOperation(value = "View all tags", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all tags"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
    public ResponseEntity<List<TagDtoResponse>> readAllByPage(
            @Min(1)
            @RequestParam int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort_by", required = false, defaultValue = "name::asc") String sortBy) {

        return new ResponseEntity<>(service.readAllPagedAndSorted(page, size, sortBy), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve specific tag with the supplied id", response = TagDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the tag with the supplied id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<TagDtoResponse> readById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }


    @Override
    @PostMapping("/create")
    @ApiOperation(value = "Create a piece of tag", response = TagDtoResponse.class)

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created a piece of tag"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
    public ResponseEntity<TagDtoResponse> create(@Valid @RequestBody TagDtoRequest createRequest) {
        return new ResponseEntity<>(service.create(createRequest), HttpStatus.CREATED);
    }


    @Override
    @PatchMapping("/update/{id}")
    @ApiOperation(value = "Update a piece of tag information", response = TagDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated tag information"),
            @ApiResponse(code = 400, message = "Illegal input for this model"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<TagDtoResponse> update(@PathVariable Long id,
                                                 @Valid
                                                 @RequestBody TagDtoRequest updateRequest) {
        return new ResponseEntity<>(service.update(updateRequest), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific tag with the supplied id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deletes the specific tag"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/by-news/{newsId}")
    @ApiOperation(value = "View tags of news with supplied id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved tags by news id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
    public ResponseEntity<List<TagDtoResponse>> readByNewsId(@PathVariable Long newsId) {
        return new ResponseEntity<>(service.readByNewsId(newsId), HttpStatus.OK);
    }

}
