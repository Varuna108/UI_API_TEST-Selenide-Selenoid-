package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Tag("api")
public class ApiPutTests {

    @Test
    void updateUser() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users/2";

        String data = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"presidentOfMatrix\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON).body(data)
                .when()
                .put()
                .then()
                .log().body()
                .statusCode(200)
                .body("job", is(equalTo("presidentOfMatrix")));
    }

    @Test
    void updatePet() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2/pet";

        String data = "{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Rex\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON).body(data)
                .when()
                .put()
                .then()
                .log().body()
                .statusCode(200)
                .body("category.name", is(equalTo("Rex")))
                .body("status", is(equalTo("available")));
    }
}

