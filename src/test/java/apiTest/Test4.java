package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test4 {

    @Test
    public void Test() {

        Response response = given().
                when().
                get("https://restful-booker.herokuapp.com/booking/9");
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",Matchers.equalTo("Susan"),
                        "totalprice",Matchers.equalTo(721),
                        "bookingdates.checkin",Matchers.equalTo("2017-06-13"));
    }
}
