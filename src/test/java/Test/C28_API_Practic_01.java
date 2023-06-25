package Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C28_API_Practic_01 {


    /*
    api/opdList endpoint'ine gecerli authorization bilgileri
    ile bir GET request gönderildiginde

    dönen status code'un 200 oldugu ve response message bilgisinin
    "Success" oldugu dogrulanmali
     */

    @Test
    public void get01(){

        // 1- spec ile baseUrl hazirla
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://www.heallifehospital.com/").build();


        // token aldık çalışmaz ise tokenş yenile
        // https://documenter.getpostman.com/view/25004583/2s93m33Npm#61047cb3-13e8-4be7-85a4-45a5fef4b81e


        String token = "hCNR4POrZ2bf4fMZ5r6ldiPmlmSEIB";

        // end pointi hazirla

        spec.pathParams("pp1","api","pp2","opdList");

        String fullPath = "/{pp1}/{pp2}";

        // response kaydet
        Response response = given ()
                .contentType(ContentType.JSON)
                .spec (spec)
                .headers(
                        "Authorization",
                        "Bearer "+ token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get (fullPath);
        response.prettyPrint();


        // assertion

        response.then().assertThat()
                .statusCode(200).body("message", Matchers.equalTo("Success"));





    }


}
