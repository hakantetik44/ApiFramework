package apiTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest3 extends TestBase {

    @Test
    public void testGetRequest() {

          Response response= given().spec(spec01).when().get();
          response.prettyPrint();

          response.then().assertThat().statusCode(200);

        JsonPath json =response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        List<String> idList=json.getList("data.findAll{Integer.valueOf(it.id)>10 }.id");
        System.out.println(idList);

        softAssert.assertEquals(idList.size(),14,"elaman sayisi uyusmadi");

        //30DAN KÜCÜK TÜM YAŞLAR
        List<String>yasList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");

        System.out.println(yasList);

        Collections.sort(yasList);
        Assert.assertEquals(yasList.get(yasList.size()-1).equals("23"),"yas istenen gibi");

        List<String> isimListesi=json.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(isimListesi);

        Assert.assertTrue(isimListesi.contains("Charde Marshall"));




        softAssert.assertAll();


    }
}
