package apiTest;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest0010 extends TestBase {


    @Test
    public void GetRequest00(){




        Response response = given().spec(spec01).when().get();
        response.prettyPrint();


        List<Map<String,String>>listOfMaps= response.as(ArrayList.class);
        System.out.println(listOfMaps);
        System.out.println(listOfMaps.get(0));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listOfMaps.size(),200);
           softAssert.assertEquals(listOfMaps.get(120).get("completed"),true,"istenen gibi");

           softAssert.assertEquals(listOfMaps.get(listOfMaps.size()-2).get("title"),"numquam repellendus a magnam");




        softAssert.assertAll();


    }

}
