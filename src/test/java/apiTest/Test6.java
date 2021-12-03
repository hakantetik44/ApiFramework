package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class Test6 extends TestBase {

    @Test
    public void test(){
        spec01.pathParams("parametre1","todos","parametre2",123);

        Response response = given().accept("application/json").
                spec(spec01).when().get("/{parametre1}/{parametre2}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).header("Server",equalTo("cloudflare"))
                .body("userId",equalTo(7),"title",equalTo("esse et quis iste est earum aut impedit"),"completed",equalTo(false));
    }
}
