package apiTest;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequest001 {
//Rest-Assured kullanarak api testing yapacagız
    @Test
    public void test(){

        given().
                when().
                get("https://restful-booker.herokuapp.com").
                then().
                assertThat()
                .statusCode(200);



    }



    @Test

    public void test1(){


        Response response = given(). when().
                get("https://restful-booker.herokuapp.com/booking/3");
        response.prettyPrint();

        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Date"));


    }


    @Test
    public void test2(){

        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();


        response.then().contentType("application/json").statusCode(200);


    }

    @Test
    public void test3Negative(){

        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking/47");
        response.prettyPrint();


        response.then().contentType("application/json").statusCode(404);


    }

    @Test
    public void test4Negative(){

        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking/1001");
        response.prettyPrint();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("Suleyman"));



    }


    @Test
    public void positiveSenaryo(){



        Response response = given().accept("application/json"). when().
                get("https://restful-booker.herokuapp.com/booking/7");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json").
                body("firstname",equalTo("Mark"),"lastname",equalTo("Jackson"),
                        "bookingdates.checkin",equalTo("2020-09-02")).body("bookingdates.checkout",equalTo("2020-09-10"),
              "additionalneeds",equalTo("Breakfast"));






    }



}
