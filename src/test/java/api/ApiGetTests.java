package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

@Tag("api")
public class ApiGetTests {

    @BeforeAll
    static void setUpAll() {
        RestAssured.baseURI = "http://kn-ktapp.herokuapp.com/apitest/accounts/";
    }

    @Test
    void notNullAccountId() {
        when()
                .get()
                .then()
                .log().body()
                .statusCode(200)
                .body("account_id", is(notNullValue()));
    }

    @Test
    void balanceMoreThan100() {
        RestAssured.basePath = "12345678";
        when()
                .get()
                .then()
                .log().body()
                .statusCode(200)
                .body("balance", is(greaterThan(100.00f)))
                .body("currency", is(equalTo("RUR")));
    }



}



