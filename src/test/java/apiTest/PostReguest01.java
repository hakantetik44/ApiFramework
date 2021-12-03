package apiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PostReguest01 extends TestBase {

    @Test
    public void testPostReguest(){

        spec01.pathParam("parametre1","booking");

        String jsonRequrstBody = "{\n" +
                " \"firstname\": \"Murat\",\n" +
                " \"lastname\": \"Smith\",\n" +
                " \"totalprice\": 123,\n" +
                " \"depositpaid\": false,\n" +
                " \"bookingdates\": {\n" +
                " \"checkin\": \"2020-09-09\",\n" +
                " \"checkout\": \"2020-09-21\"\n" +
                "},\n"+
                "\"additionalneeds\":\"Wifi\"\n"+
                " }";



        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).auth().basic("admin","password123").
                body(jsonRequrstBody).
                when().
                post("/{parametre1}");
       response.prettyPrint();

        JsonPath json = response.jsonPath();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"),"Murat");
        softAssert.assertEquals(json.getString("booking.lastname"),"Smith");
        softAssert.assertEquals(json.getInt("booking.totalprice"),123);
        softAssert.assertAll();


    }


}
