package apiTest;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponseOptions;
import org.json.JSONObject;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class PutRequest02 extends TestBase {

    @Test
    public void test(){

        Response response = given().spec(spec03).when().get("/200");
        response.prettyPrint();

        JSONObject json =new JSONObject();
        json.put("title","Hakan");
        json.put("userId","99");
        json.put("id",542);
        json.put("completed",true);


        Response responseafter = given().contentType(ContentType.JSON).spec(spec03).body(json.toString()).when().put("/200");
        responseafter.prettyPrint();


    }


}
