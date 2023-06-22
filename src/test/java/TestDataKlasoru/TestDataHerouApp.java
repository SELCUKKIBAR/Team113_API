package TestDataKlasoru;

import org.json.JSONObject;

public class TestDataHerouApp {

    public int basariliStatusKodu = 200;



    public JSONObject bookingDatesOlusturJson(){
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }

    public JSONObject bookingOlusturJson(){

        JSONObject booking = new JSONObject();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingDatesOlusturJson());
        booking.put("additionalneeds","wi-fi");

        return booking;

    }

    public JSONObject expectedBodyOlusturJson(){

        JSONObject expData = new JSONObject();

        expData.put("bookingid" , 24);
        expData.put("booking" , bookingOlusturJson());

        return expData;




    }





}
