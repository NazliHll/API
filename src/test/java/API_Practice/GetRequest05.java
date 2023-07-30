package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
    @Test
    public void test05(){
        String url="https://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2OTMzMzY4MTZ9.FwfOpzvgiW2rm9e2YV5ezTYhpJ7UPsxDNVxQk-IcIEk0NcLo7xrY9ZeIlycW71NU2VbTi7mAWc-T-jlyoInBEA";

        Response response =given().headers("Authorization","Bearer "+token).when().get(url);
        response.prettyPrint();
    }
}
