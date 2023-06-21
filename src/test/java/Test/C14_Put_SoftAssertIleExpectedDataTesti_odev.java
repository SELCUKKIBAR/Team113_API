package Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti_odev {

    /*
        http://dummy.restapiexample.com/api/v1/update/21
        url’ine asagidaki body’ye sahip bir PUT request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        Request Body
        {
            status": "success",
            data": {
                  "name": “Ahmet",
                  "salary": "1230",
                  "age": "44",
                  "id": 40
                   }
          },




        Response Body
            { "status": "success",
              "data": {
                    "status": "success",
                    "data": {
                             "name": “Ahmet",
                            "salary": "1230",
                            "age": "44",
                            "id": 40
                            }
                      },
               "message": "Successfully! Record has been updated."

             }
     */

    @Test
    public void put01(){

        // 1- url ve Request body oluştur
        String url = "https://dummy.restapiexample.com/api/v1/update/21";


        JSONObject data = new JSONObject();
        data.put("name", "Ahmet");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 40);

        JSONObject reqBody = new JSONObject();
        reqBody.put("status", "success");
        reqBody.put("data",data);

        System.out.println(reqBody);

        // 2- expected data hazirla

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data",reqBody);
        expectedData.put("message","Successfully! Record has been updated.");

        System.out.println(expectedData);

        // 3- Response kaydet
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString()).put(url);
        response.prettyPrint();


        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();
        JsonPath respJP = response.jsonPath();

        softAssert.assertEquals(respJP.get("status"),expectedData.get("status"));
        softAssert.assertEquals(respJP.get("message"),expectedData.get("message"));

        softAssert.assertEquals(respJP.get("data.data.name")
                                ,expectedData.getJSONObject("data").getJSONObject("data").get("name"));

        softAssert.assertEquals(respJP.get("data.data.salary")
                ,expectedData.getJSONObject("data").getJSONObject("data").get("salary"));

        softAssert.assertEquals(respJP.get("data.data.age")
                ,expectedData.getJSONObject("data").getJSONObject("data").get("age"));

        softAssert.assertEquals(respJP.get("data.data.id")
                ,expectedData.getJSONObject("data").getJSONObject("data").get("id"));

        softAssert.assertEquals(respJP.get("data.status")
                ,expectedData.getJSONObject("data").get("status"));


        softAssert.assertAll();







    }

}
