package com.houarizegai;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    public void shouldGetBooks() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("api/books")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    public void shouldGetBooksCount() {
        when()
                .get("api/books/count")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void shouldGetBookById() {
        given()
                .accept(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .get("api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Clean Architecture"))
                .body("price", is(35.5F))
                .body("category", is("IT"))
        ;
    }
}