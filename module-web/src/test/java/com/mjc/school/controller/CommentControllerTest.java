package com.mjc.school.controller;

import com.mjc.school.service.dto.comment.CommentDtoRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommentControllerTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1/comment";
    }

    @Test
    @Order(1)
    void shouldReturnStatusOkAfterReadAllWithParameters() {
        given().contentType(ContentType.JSON).when().get("?page=1&size=2").then().statusCode(200);
    }

    @Test
    @Order(2)
    void shouldReturnOKStatusAndEntity() {
        given().contentType(ContentType.JSON).when().get("/1").then().statusCode(200);
    }

    @Test
    @Order(3)
    void shouldCreateNewEntityAndReturnStatusCreated() {
        CommentDtoRequest commentRequestDto = new CommentDtoRequest(2L,"secondContent", LocalDateTime.now(),LocalDateTime.now(),1L);
        given().contentType(ContentType.JSON).request().body(commentRequestDto).when().post("/create").then().statusCode(201);
    }

    @Test
    @Order(4)
    void shouldUpdateEntityAndReturnStatusAccepted() {
        CommentDtoRequest commentRequestDto = new CommentDtoRequest(1L,"secondContentUpdate",
                LocalDateTime.now(),LocalDateTime.now(),1L);
        given().contentType(ContentType.JSON).request().body(commentRequestDto).when().patch("/update/1").then().statusCode(202);
    }
    /*
    @Test
    @Order(3)
    void shouldCreateNewEntityAndReturnStatusCreated() {
        NewsDtoRequest newsRequestDto = new NewsDtoRequest(1L, "thirdTitle", "thirdNewsModel",
                3L, "3", "thirdTagModel", "thirdAuthorName");
        given().contentType(ContentType.JSON).request().body(newsRequestDto)
                .when().post("/create")
                .then().statusCode(201);
    }


    @Test
    @Order(4)
    void shouldUpdateEntityAndReturnStatusAccepted() {
        NewsDtoRequest newsDtoRequest = new NewsDtoRequest(1L, "thirdTitleUpdate", "thirdNewsModelUpdate",
                3L, "3", "thirdTagModel", "thirdAuthorName");
        given().contentType(ContentType.JSON).request().body(newsDtoRequest).when().patch("/update/1").then().statusCode(202);
    }
     */

    @Test
    @Order(5)
    void shouldDeleteEntityAndReturnStatusOk() {
        given().contentType(ContentType.JSON).when().delete("/delete/2").then().statusCode(204);
    }

    @Test
    @Order(6)
    void readByNewsId() {
        given().contentType(ContentType.JSON).when().get("/by-news/1").then().statusCode(200);
    }
}