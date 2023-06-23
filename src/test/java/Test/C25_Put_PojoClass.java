package Test;

import baseUrlKlasoru.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceResuestBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */


    @Test
    public void put01 (){

        // 1- url ve requestbody hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JsonPlaceResuestBodyPojo reqBody
                =new JsonPlaceResuestBodyPojo("Ahmet","Merhaba",10,70);

        System.out.println(reqBody);



        // 2- Expected data hazirla

        JsonPlaceResuestBodyPojo expData
                =new JsonPlaceResuestBodyPojo("Ahmet","Merhaba",10,70);

        // 3- Response kaydet

        Response response = given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");

        response.prettyPrint();


        // 4- Assertion

        // JsonPath respJP = response.jsonPath();
        // HashMap<String,Object> respMap = response.as(HashMap.class);

        JsonPlaceResuestBodyPojo respPojo =response.as(JsonPlaceResuestBodyPojo.class);

        assertEquals( expData.getTitle() ,respPojo.getTitle()   );
        assertEquals( expData.getBody() ,respPojo.getBody()   );
        assertEquals( expData.getId() ,respPojo.getId()   );
        assertEquals( expData.getUserId() ,respPojo.getUserId()   );




    }

}
