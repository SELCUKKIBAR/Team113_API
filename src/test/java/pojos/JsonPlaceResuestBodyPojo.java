package pojos;

public class JsonPlaceResuestBodyPojo {

    /*
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    // 1- objeleri private hazirla
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2- geter ve seterları hazirla


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3- Tüm prametreleri içeren constructur oluştur


    public JsonPlaceResuestBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    // 4- parametresiz constructur oluştur


    public JsonPlaceResuestBodyPojo() {
    }

    // 5- toString() methodu oluştur


    @Override
    public String toString() {
        return "JsonPlaceResuestBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }

    // 1.34 de kaldım....
}
