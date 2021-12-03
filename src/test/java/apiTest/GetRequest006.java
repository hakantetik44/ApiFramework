package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest006 extends TestBase {

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

    @Test
    public void testGetRequest06(){
        spec02.pathParams("parametre1","booking","parametre2",5);
        Response response = given().spec(spec02).
                accept("application/json").
                when().
                get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        JsonPath json = response.jsonPath();
        System.out.println(json.getString("firstname"));

        assertEquals("istenilen gibi degil", json.getString("firstname"),("Jim"));
        assertEquals("istenilen gibi degil", json.getString("lastname"),("Brown"));

        assertEquals("istenilen gibi degil",580, json.getInt("totalprice"));

        assertEquals("istenilen gibi degil",false, json.getBoolean("depositpaid"));
        System.out.println(json.getString("lastname"));
        System.out.println(json.getInt("totalprice"));
        System.out.println(json.getBoolean("depositpaid"));

        System.out.println(json.getString("bookingdates"));


    }
}
