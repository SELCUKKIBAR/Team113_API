package Test;

import TestDataKlasoru.TestDataHerouApp;
import baseUrlKlasoru.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseURL {

    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){

        // 1- url ve request body hazirla

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerouApp testDataHerouApp = new TestDataHerouApp();

        JSONObject reqBody = testDataHerouApp.bookingOlusturJson();
        System.out.println(reqBody);


        // 2- Expected Data oluştur...

        JSONObject expData = testDataHerouApp.expectedBodyOlusturJson();

        // 3- Response Kaydet....

        Response response = given()
                                    .spec(specHerokuApp)
                                    .contentType(ContentType.JSON)
                                .when()
                                    .body(reqBody.toString()).post("/{pp1}");

        response.prettyPrint();



        // 4- Assertion...

        JsonPath responeJP = response.jsonPath();
        assertEquals(expData.getJSONObject("booking").get("firstname")
                ,responeJP.get("booking.firstname"));

        assertEquals(expData.getJSONObject("booking").get("lastname")
                ,responeJP.get("booking.lastname"));

        assertEquals(expData.getJSONObject("booking").get("totalprice")
                ,responeJP.get("booking.totalprice"));

        assertEquals(expData.getJSONObject("booking").get("depositpaid")
                ,responeJP.get("booking.depositpaid"));

        assertEquals(expData.getJSONObject("booking").get("additionalneeds")
                ,responeJP.get("booking.additionalneeds"));

        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin")
                ,responeJP.get("booking.bookingdates.checkin"));

        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout")
                ,responeJP.get("booking.bookingdates.checkout"));

    }


}
