package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest007 extends TestBase {

    @Test
    public void getreguest(){

        Response response = given().spec(spec01).when().get();
        response.prettyPrint();


        JsonPath json = response.jsonPath();
        System.out.println(json.getString("data.employee_name"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garrett Winters","istenen isim ");

        softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"),"istenen isim");

        softAssert.assertEquals(json.getList("data.id").size(),24,"HATALI LÜTFEN TEKRAR GİRİNİZ");

        softAssert.assertEquals(json.getString("data[6].employee_salary"),"137500","uyusmadi");


        softAssert.assertAll();




        //



    }




}
