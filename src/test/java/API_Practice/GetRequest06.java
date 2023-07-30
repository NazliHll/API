package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class GetRequest06 extends Authentication {
    @Test
    public void test06(){
        String url="https://www.gmibank.com/api/tp-customers/126294";

        Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(url);
        response.prettyPrint();
    }
}
