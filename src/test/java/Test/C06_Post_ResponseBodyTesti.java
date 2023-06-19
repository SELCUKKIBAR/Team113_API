package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTesti {

    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01(){

        // 1- url ve Request body oluştur...
        String url = "https://jsonplaceholder.typicode.com/posts";

        /*
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
         */
        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println("ReqBody...: "+reqBody);

        // 2 - Expected daha hazırla ama hala yok

        // 3- Response kaydet
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post(url);
        response.prettyPrint();


        // 4- Assertion
        response.then().assertThat().statusCode(201);
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().body("title", Matchers.equalTo("API"));
        response.then().assertThat().body("userId", Matchers.lessThan(100));
        response.then().assertThat().body("body", Matchers.containsString("API"));

        }


    }


