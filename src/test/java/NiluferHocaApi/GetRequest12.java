package NiluferHocaApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.HerokuappTestData;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends TestBase {
    @Test
    public void test() {
        spec02.pathParams("parametre1", "booking"
                , "parametre2", 1);

        //expected data
        HerokuappTestData expectedObject = new HerokuappTestData();
        HashMap<String, Object> expectedDataMap = expectedObject.setupTestData();
        System.out.println(expectedDataMap);

        //request gönder

        Response response = given().accept("application/json").spec(spec02).when().get("/{parametre1}/{parametre2}");
        response.prettyPrint();

        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        Assert.assertEquals(expectedDataMap.get("bookingdates.checkin"), actualDataMap.get("bookingdates.checkin"));
        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkin"),
                ((Map) actualDataMap.get("bookingdates")).get("checkin"));

        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkout"),
                ((Map) actualDataMap.get("bookingdates")).get("checkout"));

        JsonPath json = response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("firstname"), json.getString("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), json.getString("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), json.getInt("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), json.getString("depositpaid"));
        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkin")
                , json.getString("bookingdates.checkin"));
        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkout")
                , json.getString("bookingdates.checkout"));


    }


}
