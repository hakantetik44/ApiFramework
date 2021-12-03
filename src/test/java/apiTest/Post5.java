package apiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.Booking;
import utilities.Bookingdates;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class Post5 extends TestBase {
    @Test
    public void test(){


        /*accept type json olsun
post request yolladıgında requestbody
{
 "firstname": "Eric",
 "lastname": "Smith",
 "totalprice": 555,
 "depositpaid": false,
 "bookingdates": {
 "checkin": "2016-09-09",
 "checkout": "2017-09-21"
 }
 "additionalneeds": "Wifi"
 }
 Then
status code 200 olmalı
response body nın request body ile aynı old verify yapınız

}


*/


        Bookingdates bookingdates = new Bookingdates("2016-09-09","2017-09-21");
        Booking booking = new Booking("Mehmet","Bulutluoz",123,true,bookingdates,"Wifi");

        Response response =given().contentType(ContentType.JSON).spec(spec01).auth().basic("admin","password").body(booking).when().post("/booking");
        response.prettyPrint();


        JsonPath json=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("booking.firstname"), booking.getFirstname());
        softAssert.assertEquals(json.getString("booking.lastname"), booking.getLastname());
        softAssert.assertEquals(json.getInt("booking.totalprice"), 123);
        softAssert.assertEquals(json.getBoolean("booking.depositpaid"), true);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), booking.getBookingdates().getCheckin());
        softAssert.assertEquals(json.getString("booking.bookingdates.checkout"), booking.getBookingdates().getCheckout());
        softAssert.assertEquals(json.getString("booking.additionalneeds"), booking.getAdditionalneeds());
        softAssert.assertAll();
    }






















}

