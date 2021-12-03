package apiTest;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonUtil;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ObjectMapperTestWithmap extends TestBase {

    @Test
    public void javaToJson(){

        HashMap<Integer,String> map = new HashMap<>();

        map.put(101,"Ali");
        map.put(102,"Ahmet");
        map.put(103,"Asım");


        System.out.println(map);

   String jsonFromMap= JsonUtil.convertJavaToJson(map);
        System.out.println(jsonFromMap);



    }


    @Test
    public void jsonToJava(){

        Response response = given().spec(spec01).when().get("/booking/3");

        response.prettyPrint();

        Map<String,Object> jsonToMap = JsonUtil.convertJsonToJava(response.asString(), Map.class);


        System.out.println(jsonToMap);


    }
}
