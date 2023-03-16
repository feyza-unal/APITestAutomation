import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_PutResponseBilgileriAssertion {
    @Test
    public void test01() {
        /*
       https://jsonplaceholder.typicode.com/posts/70
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }

        donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin cloudflare,
        ve status Line’in HTTP/1.1 200 OK oldugunu test et
         */

        //1- end point ve request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Ahmet");
        requestBody.put("body", "Merhaba");
        requestBody.put("userId", 10);
        requestBody.put( "id", 70);

        //2- expected body olustur
        //3- request gonder ve donen response'u kaydet

        Response response = given().contentType(ContentType.JSON) //body nin json formatinda oldugunu soylemeliyiz
                            .when().body(requestBody.toString()) //olusturdugumuz body'i stringe cevirdik
                            .put(url); //update icin put diyoruz

        //4- assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");




    }
}
