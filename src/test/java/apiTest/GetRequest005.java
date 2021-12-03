package apiTest;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GetRequest005 extends TestBase {

    @Test
    public void testGetRequest005() {
        spec02.queryParams("parametre1","booking","firstname", "Susan"

                );

        Response response = given().accept("application/json").spec(spec02).
                when().get("/{parametre1}/{booking}");
       response.prettyPrint();

     assertTrue(response.getBody().asString().contains("firstaname"));














    }
}
