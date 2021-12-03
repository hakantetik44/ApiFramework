package apiTest;

import io.restassured.response.Response;


import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


import static org.junit.Assert.*;

public class Test2 {
    @Test

    public void test1() {

        Response response = given().
                when().
                accept("application/json").
                get("https://restful-booker.herokuapp.com/booking/");
        response.prettyPrint();

        response.
                then().
                assertThat().
                contentType("application/json").
                statusCode(200);

        System.out.println(response.getHeaders());

        System.out.println("-*********--------\n");
        System.out.println(response.getContentType());

    }

    @Test
    public void test2() {

      Response response=  given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/3");


      response.prettyPrint();
              response.then().
                assertThat().
                statusCode(200).
                contentType("application/json");


    }

    @Test
    public void test3() {

         Response response =  given().when().get("https://restful-booker.herokuapp.com/booking/11");
        response.prettyPrint();


        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("Not Found"));

        assertFalse(response.asString().contains("Suleyman"));








    }
  @Test

    public void test4() {

        Response response = given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/9");

        response.prettyPrint();

 response.then().assertThat().statusCode(200).contentType("application/json").body("firstname",Matchers.equalTo("Jim")).body("lastname",Matchers.equalTo("Ericsson"));




  }










}
