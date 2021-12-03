package apiTest;

import org.json.JSONObject;
import org.junit.Test;
import utilities.TestBase;

public class PostRequest02 extends TestBase {

    @Test
    public void testPost1(){
        JSONObject jsonBookingDatesBody = new JSONObject();
        jsonBookingDatesBody.put("checkin", "2020-09-09");
        jsonBookingDatesBody.put("checkout", "2020-09-21");

        JSONObject jsonRequestBody = new JSONObject();
        jsonRequestBody.put("firstname","Murat");
        jsonRequestBody.put("lastname","Smith");
        jsonRequestBody.put("totalprice",123);
        jsonRequestBody.put("depositpaid","false");
        jsonRequestBody.put("bookingdates",jsonBookingDatesBody);
        jsonRequestBody.put("additionalneeds","Wifi");






    }
}
