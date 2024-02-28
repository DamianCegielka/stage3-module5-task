package com.mjc.school.controller;

import com.mjc.school.service.dto.tag.TagDtoRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TagControllerTest {
    @BeforeAll
    public static void setup() {
        http:
//localhost:8080/swagger-ui/index.html#/
        RestAssured.baseURI = "http://localhost:8080/api/v1/tag";
    }

    @Test
    @Order(1)
        //@Disabled
    void shouldReturnStatusOkAfterReadAllWithParameters() {
        given().contentType(ContentType.JSON).when().get("?page=1&size=2").then().statusCode(200);
    }

    @Test
    @Order(2)
        //@Disabled
    void shouldReturnOKStatusAndEntity() {
        given().contentType(ContentType.JSON).when().get("/1").then().statusCode(200);
    }

    @Test
    @Order(3)
        //@Disabled
    void shouldCreateNewEntityAndReturnStatusCreated() {
        TagDtoRequest tagRequestDto = new TagDtoRequest(1L, "firstTagModel");
        given().contentType(ContentType.JSON).request().body(tagRequestDto).when().post("/create").then().statusCode(201);
    }

    @Test
    @Order(4)
        //@Disabled
    void shouldUpdateEntityAndReturnStatusAccepted() {
        TagDtoRequest tagRequestDto = new TagDtoRequest(1L, "firstTagModel");
        given().contentType(ContentType.JSON).request().body(tagRequestDto).when().patch("/update/1").then().statusCode(202);
    }

    @Test
    @Order(5)
        //@Disabled
    void shouldDeleteEntityAndReturnStatusOk() {
        given().contentType(ContentType.JSON).
                when().delete("/delete/{id}", 2).
                then().statusCode(204);
    }

    @Test
    @Order(6)
        //@Disabled
    void readByNewsId() {
        given().contentType(ContentType.JSON).when().get("/by-news/1").then().statusCode(200);
    }
}