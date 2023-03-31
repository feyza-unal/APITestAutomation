package pojos;

public class PojoJasonPlaceholder {
//            "title":"Ahmet",
//            "body":"Merhaba",
//            "userId":10,
//            "id":70

//1) Tum variable’lari "private" olarak olusturalim
    private String title;
    private String body;
    private int userId;
    private int id;


//2) Tum variable’lar icin getter( ) and setter( ) metodlari olusturalim (sag tik generate getter setter)

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


//3) Tum parametreleri iceren bir constructor olusturalim

    public PojoJasonPlaceholder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

// 4) Default constructor (parametresiz) olusturalim

    public PojoJasonPlaceholder() {
    }


//5) toString( ) metodu olusturalim

    @Override
    public String toString() {
        return "PojoJasonPlaceholder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
