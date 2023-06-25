package Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C28_API_Practic_03_tokenotomatikalma {

    public String token;


    @Test
    public void get01(){

        // 1- spec ile baseUrl hazirla
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://www.heallifehospital.com/").build();


        // token aldık çalışmaz ise tokenş yenile
        // https://documenter.getpostman.com/view/25004583/2s93m33Npm#61047cb3-13e8-4be7-85a4-45a5fef4b81e


        String token = tokenCreate();

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


    @Test
    public void get02(){

        // 1- spec ile baseUrl hazirla
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://www.heallifehospital.com/").build();


        // token aldık çalışmaz ise tokenş yenile
        // https://documenter.getpostman.com/view/25004583/2s93m33Npm#61047cb3-13e8-4be7-85a4-45a5fef4b81e


        String token = "hCNR4POrZ2bf4sdsdfMZ5r6ldiPmlmSEIB";

        // end pointi hazirla

        spec.pathParams("pp1","api","pp2","opdList");

        String fullPath = "/{pp1}/{pp2}";

        // response kaydet hata kodu 403 olduğu için sistem exception furlatıyor

        String expectionMsj ="";
        try {
            Response response = given ()
                    .contentType(ContentType.JSON)
                    .spec (spec)
                    .headers(
                            "Authorization",
                            "Bearer "+ token,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON
                    )
                    .when()
                    .get (fullPath);
        } catch (Exception e) {
            expectionMsj = e.getMessage();
        }
        //response.prettyPrint();


        // assertion

        System.out.println(expectionMsj);

        Assert.assertTrue(expectionMsj.contains("status code: 403"));




    }



    public String tokenCreate(){

        String url = "https://www.heallifehospital.com/api/getToken";

        JSONObject requBody = new JSONObject();

        requBody.put("email","hatice.kubra.ceylan.admin@heallifehospital.com");
        requBody.put("password","heallife123");

        Response response = given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(requBody.toString())
                        .post(url);

        response.prettyPrint();
        // tokeni alabilmek için response jsonpath yap
        JsonPath jsonResponse = response.jsonPath();

        token =jsonResponse.getString("token");




        return token;


    }

}
