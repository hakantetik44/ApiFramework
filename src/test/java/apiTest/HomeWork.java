package apiTest;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class HomeWork extends TestBase {

    @Test
    public void test() {
        Response response = given().spec(spec01).when().get();
        response.prettyPrint();

        assertTrue(response.asString().contains("message\": \"Successfully! Record has been fetched."));










    }


}
