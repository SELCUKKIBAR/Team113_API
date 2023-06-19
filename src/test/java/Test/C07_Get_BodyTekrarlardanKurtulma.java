package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_BodyTekrarlardanKurtulma {

     /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 609,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){

        // 1- url hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected data oluştur ama hala yok

        // 3- Response i kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4 - Assertion
        /*
        response.then().assertThat()
                        .statusCode(200)
                        .contentType("application/json; charset=utf-8")
                        .body("firstname", Matchers.equalTo("Mark"),
                               "lastname",Matchers.equalTo("Jones"),
                                "totalprice",Matchers.equalTo(205),
                                "depositpaid",Matchers.equalTo(false),
                                "additionalneeds",Matchers.equalTo("Breakfast"));

         */


        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jones"),
                        "totalprice",equalTo(205),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));




    }

}
