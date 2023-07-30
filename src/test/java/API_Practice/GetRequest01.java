package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void test01(){

        String url="https://restful-booker.herokuapp.com/booking";
        Response response= given().when().get(url);
        // given().when().get(url) -> end point'e göndermek için request oluşturmuş olduk.
        // Response response -> api tarafından bana dönen response (cevap)

        // Response response = given().auth().basic("username", "password" ).when().get(url)
        // basic auth ile request göndermek için

        //response.prettyPrint();          // response'daki body'i yazdırır

        //response.prettyPeek();           // response'daki her şeyi yazdırır

        // response.peek();                 // Header'ı ve string olarak datayı verir.Body'i vermez

        // response.print();                // string olarak datayı verir
        // [{"bookingid":1747},{"bookingid":2639},{"bookingid":1291},{"bookingid":1531},{"bookingid":792}...

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) JUnit Assert leri ile API testi yapabiliriz.
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());

        // 2) assertThat ile
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
