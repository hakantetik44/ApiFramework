package apiTest;

import org.junit.Test;
import utilities.Bookingdates;
import utilities.JsonUtil;

public class ObjectMapperTestWithPoJo {
    @Test
    public void pojo() {


        Bookingdates bookingdates = new Bookingdates("2020-11-02","2020-11-08");

        String jsonFromJava = JsonUtil.convertJavaToJson(bookingdates);
        System.out.println(jsonFromJava);
    }

}
