package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Tag("api")
public class ApiPostTests {

    @BeforeAll
    static void setUpAll() {
        RestAssured.baseURI = "https://reqres.in/";

    }

    @Test
    void createNewUser() {
        RestAssured.basePath = "/api/users";
        String data = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON).body(data)
                .when()
                .post()
                .then()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"));
    }

    @Test
    void successLogin() {
        RestAssured.basePath = "/api/users/2";
        String data = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON).body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("token", is(notNullValue()));
    }
}
