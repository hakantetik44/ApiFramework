package apiTest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Test1 {

    @Test
    public void getmethod1() {

        given().
                when().
                get("https://restful-booker.herokuapp.com/booking").
                then().
                assertThat().
                statusCode(200);

    }

    //get ile aldığım datayı console de görmek istiyorum.
    @Test
    public void getMethod2() {

        Response response = given().
                when().
                get("https://restful-booker.herokuapp.com/booking/3");
       //console yazdırmak icin
        response.prettyPrint();
   //status code u console da gormek icin
        System.out.println("status code : "+  response.statusCode());

        System.out.println("status line : " + response.getStatusLine());
//respnde bodyde ki datanin content icerik type icin

        System.out.println(response.contentType());
      //Headersteki tüm elamanlları almak icin
        System.out.println(response.getHeaders());

        //headers istenen specific bilgi icin
        System.out.println(response.getHeader("Date"));

        //Assertion yapalım
        response.
                then().assertThat().contentType("application/json").statusCode(200);






    }
}
