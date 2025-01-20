package git.io.yhugorocha.resources;

import git.io.yhugorocha.config.WithCustomBroker;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(ExpenseResource.class)
@WithCustomBroker(nameDatabase = "db_teste", username = "postgres",
        password = "postgres", port = "5432")
class ExpenseResourceTest {

    @Test
    void textCreateExpense(){
        given()
                .body("")
                .contentType(ContentType.JSON)
        .when()
                .post();

        when()
                .get()
        .then()
                .statusCode(200)
                .body("size()", is(1));
    }
}