package apiTest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class GetRequest002 {

    @Test
    public void testGetRequest(){

        Response response = given().
                accept("application/JSON").
                when().
                get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/JSON").

        body("data.id", Matchers.hasSize(24)).
                body("data.employee_name",Matchers.hasItem("Doris Wilder"),
                "data.employee_age",Matchers.hasItems(61,63,66));




    }







}
