package TestDataKlasoru;

import org.json.JSONObject;

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


}
