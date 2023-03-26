package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C25_PutTestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {
        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
        PUT request yolladigimizda donen response’in
        status kodunun 200, content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        Request Body
        { "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        Expected Data :
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
         */

        //1-endpoint request body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        JSONObject requestBody = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");
        //System.out.println(requestBody);

        //2-expected data olustur
        JSONObject expectedData = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //3-request gonder ve donen response'i kaydet
        Response response = given().spec(specJsonPlaceHolder)
                .when().body(requestBody.toString()).contentType(ContentType.JSON)
                .put("{pp1}/{pp2}");
       // response.prettyPrint();

        //4-assertion

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        JsonPath responsePath = response.jsonPath();
        assertEquals(expectedData.getInt("id"),responsePath.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responsePath.getInt("userId"));
        assertEquals(expectedData.getString("title"),responsePath.getString("title"));
        assertEquals(expectedData.getString("body"),responsePath.getString("body"));

    }
}
