package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post3  extends TestBase {

    @Test
    public void Test(){

        Map<String,String> bookingDatesMap = new HashMap();
        bookingDatesMap.put("checkin","Murat");
        bookingDatesMap.put("checkout","2020-09-21");


        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname","Murat");
        requestBodyMap.put("lastname","Smith");
        requestBodyMap.put("totalprice",123);
        requestBodyMap.put("depositpaid",true);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds","Wifi");

        Response response = given().
                contentType(ContentType.JSON).spec(spec01).auth().
                basic("admin", "password123").
                body(requestBodyMap).when().
                post("/booking");


           response.prettyPrint();

    }


}
