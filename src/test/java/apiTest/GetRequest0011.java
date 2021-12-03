package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest0011 extends TestBase {
    @Test
    public  void testGetRequest34() {

        Response response = given().spec(spec02).when().get();
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data[0].employee_name"),"Tiger Nixon");
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garret Winters");
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(json.getString("data[3].employee_name"),"Cedric Kelly");
        softAssert.assertEquals(json.getString("data[4].employee_name"),"Airi Satou");



        List<Map>actualList=json.getList("data");
         Map<Integer, String>expectedMap= new HashMap<>();
         expectedMap.put(0,"Tiger Nixon");
        expectedMap.put(1,"Garret Winters");
        expectedMap.put(2,"Ashton Cox");
        expectedMap.put(3,"Cedric Kelly");
        expectedMap.put(4,"Airi Satou");


        for (int i = 0; i < expectedMap.size(); i++) {

            softAssert.assertEquals(actualList.get(i).get("employee_name"),expectedMap.get(i));
            
        }

        softAssert.assertAll();










    }
}
