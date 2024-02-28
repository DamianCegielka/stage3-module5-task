package com.mjc.school.controller;

import com.mjc.school.service.AuthorService;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorControllerTest {
    private AuthorService authorService;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1/author";
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
        AuthorDtoRequest authorRequestDto = new AuthorDtoRequest(2L, "Name");
        given().contentType(ContentType.JSON).request().body(authorRequestDto).when().post("/create").then().statusCode(201);
    }

    @Test
    @Order(4)
    void shouldUpdateEntityAndReturnStatusAccepted() {
        AuthorDtoRequest authorRequestDto = new AuthorDtoRequest(2L, "Name");
        given().contentType(ContentType.JSON).request().body(authorRequestDto).when().patch("/update/2").then().statusCode(202);
    }

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