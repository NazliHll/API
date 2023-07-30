package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void test01(){

        String url="https://restful-booker.herokuapp.com/booking";
        Response response= given().when().get(url);
        // given().when().get(url) -> end point'e göndermek için request oluşturmuş olduk.
        // Response response -> api tarafından bana dönen response (cevap)


    }
}
