package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest008 extends TestBase {

    @Test
    public void testGetRequest008(){
        Response response = given().spec(spec02).when().get();
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        SoftAssert softAssert = new SoftAssert();

        JsonPath json = response.jsonPath();
        List<Integer> idList = json.getList("data.findAll{it.id>10}.id");
        System.out.println(idList);

        softAssert.assertEquals(idList.size(),14,"sorun verdi");
        System.out.println("Ondan büyük :"+ idList.size());



        List<Integer>idList2 = json.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println(idList2);

        Collections.sort(idList2);
        System.out.println(idList2);
        System.out.println(idList2.get(idList2.size()-1).equals(23));

        List<String>idList3=json.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(idList3);
        softAssert.assertTrue(idList3.contains("Charde Marshall"),"Lütfen tekrar deneyiniz");





        softAssert.assertAll();

    }






}
