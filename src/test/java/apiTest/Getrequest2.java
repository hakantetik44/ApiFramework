package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Getrequest2 extends TestBase {

    @Test
    public void testGet() {
        Response response = given().spec(spec03).when().get();
        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getList("data.employee_name"));

   assertEquals("İstenen gibi gibi isim değil", "Garrett Winters",jsonPath.getString("data[1].employee_name"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getString("data[1].employee_name"),"Garrett Winters","isim istenen gibi değil");
        softAssert.assertTrue(jsonPath.getList("data.employee_name").contains("Herrod Chandler"));

        softAssert.assertEquals(jsonPath.getList("data.id").size(),24,"24 isci yok");

        softAssert.assertEquals(jsonPath.getString("data[6].employee_salary"),137500);

        softAssert.assertAll();


    }


}
