package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C13_Get_SoftAssertIleExpectedDataTesti_odev {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3
            url’ine bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status": "success",
         "data": {
               "id": 3,
               "employee_name": "Ashton Cox",
               "employee_salary": 86000,
               "employee_age": 66,
               "profile_image": ""
                  },
        "message": "Successfully! Record has been fetched." }
     */

    @Test
    public void get01(){

        // 1- url oluştur

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected data hazirla
        JSONObject expectedData = new JSONObject();
        expectedData.put("id", 3);
        expectedData.put("employee_name","Ashton Cox");
        expectedData.put("employee_salary", 86000);
        expectedData.put("employee_age",66);
        expectedData.put("profile_image", "");

        JSONObject responeData = new JSONObject();
        responeData.put("status", "success");
        responeData.put("data",expectedData);
        responeData.put("message", "Successfully! Record has been fetched.");

        System.out.println("Response Data...: "+responeData);

        // 3- Response kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();
        JsonPath respJP=response.jsonPath();


        softAssert.assertEquals(respJP.get("status"),responeData.get("status"));
        softAssert.assertEquals(respJP.get("message"),responeData.get("message"));
        softAssert.assertEquals(respJP.get("data.id"),responeData.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"),responeData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"),responeData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"),responeData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"),responeData.getJSONObject("data").get("profile_image"));





        softAssert.assertAll();


    }

}
