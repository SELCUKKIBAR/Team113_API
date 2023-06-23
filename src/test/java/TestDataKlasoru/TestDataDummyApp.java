package TestDataKlasoru;

import java.util.HashMap;

public class TestDataDummyApp {

    public int basariliStatusKod = 200;
    public String contentType ="application/json";

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.
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

    public HashMap dataBodyOlusturMap(){

        HashMap<String,Object> data = new HashMap<>();
        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");


        return data;
    }


    public HashMap expectedDataBodyOlusturMap(){

        HashMap<String,Object> expBody = new HashMap<>();
        expBody.put("data",dataBodyOlusturMap());
        expBody.put("status","success");
        expBody.put("message","Successfully! Record has been fetched.");

        return expBody;
    }

}
