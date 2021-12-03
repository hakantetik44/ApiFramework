package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest009 extends TestBase {

    @Test
    public void testGetRequestGson(){

        spec01.pathParam("parametre1",2);

        Response response = given().spec(spec01).when().get("/{parametre1}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        HashMap<String,String> map =response.as(HashMap.class); //de-serilazisoton

        System.out.println(map);

        System.out.println(map.keySet());
        System.out.println(map.values());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(map.get("completed"),false,"Uygun değil");
        softAssert.assertEquals(map.get("userId"),1 ,"yanlis");
        softAssert.assertEquals(map.get("id"),2,"yanlis");
        softAssert.assertEquals(map.get("title"),"quis ut nam facilis et officia qui","yanlis");







        softAssert.assertAll();










    }







}
