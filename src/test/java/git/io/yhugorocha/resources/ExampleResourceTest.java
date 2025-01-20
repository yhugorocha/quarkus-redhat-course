package git.io.yhugorocha.resources;

import git.io.yhugorocha.clients.HelloClient1;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


@QuarkusTest
@TestHTTPEndpoint(ExampleResource.class)
class ExampleResourceTest {

    @InjectMock
    @RestClient
    HelloClient1 helloClient1;

    @Test
    void testMockRestClient(){
        Mockito.when(helloClient1.hello()).thenReturn("Hugo test");

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/client")
        .then()
                .statusCode(200)
                .body(is("Hugo test"));


    }
}