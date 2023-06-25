package Test;

import baseUrlKlasoru.DummyAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.duumyDataPojo;
import pojos.duumyExpectedBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Get_Pojo_Veda_Classi extends DummyAppBaseUrl {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */


    @Test

    public void get01(){
        // 1 - url hazirla

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2- expected data hazirla

        duumyDataPojo data = new duumyDataPojo(3,"Ashton Cox",86000,66,"");
        duumyExpectedBodyPojo  expBody = new duumyExpectedBodyPojo("success",data,"Successfully! Record has been fetched.");


        // 3- Response kaydet

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();


        // 4- Assertion

        duumyExpectedBodyPojo resPOJO = response.as(duumyExpectedBodyPojo.class);

        assertEquals(expBody.getStatus(),resPOJO.getStatus());
        assertEquals(expBody.getMessage(),resPOJO.getMessage());
        assertEquals(expBody.getData().getId(),resPOJO.getData().getId());
        assertEquals(expBody.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        assertEquals(expBody.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        assertEquals(expBody.getData().getProfile_image(),resPOJO.getData().getProfile_image());







    }


}
