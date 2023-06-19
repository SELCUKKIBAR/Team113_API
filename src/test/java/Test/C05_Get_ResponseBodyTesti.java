package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti {

    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
             status code'unun 200,
             ve content type'inin ContentType.JSON,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
             oldugunu test edin.
     */

    @Test
    public void get01(){

        // 1-  Endpoint hazırla...
        String  url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected data hazirla ama hala yok

        // 3- Response kaydet...
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType(ContentType.JSON);
        response.then().assertThat().body("userId", Matchers.equalTo(5));
        response.then().assertThat().body("title",Matchers.equalTo("optio dolor molestias sit"));



    }

}
