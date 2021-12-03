package apiTest;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class GetRequest003 extends TestBase {

    /* when ı send a get request to rest apı url
    https://restful-booker.herokuapp.com/booking/5
    then http status code 200 olsun
    and firstname should be jim
    and totalprice should be 602
    and checkin should be 2015-06-12
     */


    @Test
    public void testGetRequest3(){

        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/5");

        response.prettyPrint();

        response.then().statusCode(200).contentType("application/JSON").
                body("firstname", equalTo("Eric"),
                        "totalprice",equalTo(421),
                        "bookingdates.checkin",equalTo("2021-09-02"));








    }
}
