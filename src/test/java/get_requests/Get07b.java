package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07b extends JsonPlaceHolderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos/2
       When
           I send GET Request to the URL
       Then
           Status code is 200
           And "completed" is false
           And "userId" is 1
           And "title" is "quis ut nam facilis et officia qui"
           And header "Via" is "1.1 vegur"
           And header "Server" is "cloudflare"
           {
               "userId": 1,
               "id": 2,
               "title": "quis ut nam facilis et officia qui",
               "completed": false
           }
    */
    @Test
    public void test07() {
        spec.pathParams("first", "todos", "second", 2);
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        System.out.println(expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals("1.1 vegur", response.header("Via"));
        assertEquals("cloudflare", response.header("Server"));
        assertEquals(200, response.statusCode());

    }

    @Test
    public void test07b() {
        spec.pathParams("first", "todos", "second", 2);

        JsonPlaceHolderTestData objJsonPlcHldr = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = objJsonPlcHldr.expectedDataMethod(1, "quis ut nam facilis et officia qui", false);


        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals("1.1 vegur", response.header("Via"));
        assertEquals("cloudflare", response.header("Server"));
        assertEquals(200, response.statusCode());
    }
}