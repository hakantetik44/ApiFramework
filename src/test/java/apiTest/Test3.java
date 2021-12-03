package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test3 {
    @Test
    public void test() {


        Response response =  given().
                accept(ContentType.JSON).
                when().
                get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", Matchers.hasSize(24)).
                body("data.employee_name",Matchers.hasItem("Doris Wilder"));







    }
}
