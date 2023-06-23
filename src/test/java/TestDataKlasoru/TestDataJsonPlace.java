package TestDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlace {

    public String contentType = "application/json; charset=utf-8";

    public String connectionHeaderDegeri = "keep-alive";
    public int basariliStatusKodu = 200;

    public JSONObject expectedBodyOlusturJson(){

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        return expectedData;
    }

    public JSONObject requestBodyOlusturJson(){

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","Ali");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);


        return reqBody;
    }

    public HashMap requestBodyOlusturMap(){

        HashMap<String , Object> reqBody = new HashMap<>();

        /*
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
         */

        reqBody.put("title","Ali");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10.0);
        reqBody.put("id",70.0);

        return reqBody;
    }




}
