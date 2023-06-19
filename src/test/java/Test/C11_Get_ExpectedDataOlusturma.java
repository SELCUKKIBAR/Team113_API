package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {

    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        // 1- url  hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected data hazirla
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        System.out.println("Expected Data...: "+expectedData);

        // 3- Response kaydet
        Response response = given().when().get(url);
        response.prettyPrint();
        // response.prettyPeek();//prettyprintten farklı olarak tüm detaylari döndürür...

        // 4- Assertion


        JsonPath respJP=response.jsonPath();
        assertEquals(expectedData.get("userId"), respJP.get("userId"));
        assertEquals(expectedData.get("id"), respJP.get("id"));
        assertEquals(expectedData.get("title"), respJP.get("title"));
        assertEquals(expectedData.get("body"), respJP.get("body"));




    }

}
