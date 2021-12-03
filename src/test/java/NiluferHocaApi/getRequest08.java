package NiluferHocaApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class getRequest08 extends TestBase {
    @Test
    public void test(){

        spec03.pathParam("parametre1","employees");

        Response response = given().accept("application/json")
                .spec(spec03).
                when().
                get("/{parametre1}");

        response.prettyPrint();

        JsonPath jsonPath =response.jsonPath();
        System.out.println(jsonPath.getString("data[2].employee_name"));






    }


}
