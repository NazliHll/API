package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class Get12Pojo extends RestfulBaseUrl {

    /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
         I send GET Request to the URL
     Then
        Status code is 200
     And
        Response body is like:
   {

    "firstname": "Jane",
    "lastname": "Doe",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Extra pillows please"
}
    */
    @Test
    public void get12Pojo(){
        spec.pathParams("first","booking","second",18);

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        System.out.println(bookingDatesPojo.toString());
        BookingPojo bookingPojo=new BookingPojo("Jane","Doe",111,true,bookingDatesPojo,"Extra pillows please");
        System.out.println(bookingPojo);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData=response.as(BookingPojo.class);

    }
}
