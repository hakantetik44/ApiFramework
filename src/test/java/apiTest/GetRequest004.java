package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class GetRequest004 extends TestBase {
    @Test
    public void testGetRequest04() {

        /*
        https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
        HTTP Status Code’unun 200
        ve response content type’inin “application/JSON” oldugunu
        ve response body’sinin asagidaki gibi oldugunu test edin
        {"firstname": Sally,
                "lastname": "Smith",
                "totalprice": 789,
                "depositpaid": false,
                "bookingdates": {
                   "checkin": "2017-12-11",
                    "checkout":"2020-02-20"
                     }
        }
    */


        spec02.pathParams("parametre1", "booking",
                "parametre2", 2);


        Response response = given().spec(spec02).
                accept("application/json").
                when().
                get("/{parametre1}/{parametre2}");

        //ikinci yöntem get("/booking/5);
        response.prettyPrint();


        response.then().contentType(ContentType.JSON).
                statusCode(200).body("firstname", equalTo("Hakan"),
                        "lastname", equalTo("Tetik"),
                        "totalprice", equalTo(861),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2021-03-29"),
                        "bookingdates.checkout", equalTo("2021-04-08"));


    }
}
