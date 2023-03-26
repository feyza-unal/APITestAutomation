package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C24_GetTestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {
    /*
    https://jsonplaceholder.typicode.com/posts/40 url'ine bir
    GET request yolladigimizda donen response’in status kodunun
    200 ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        Response body :
        {
        "userId": 4,
        "id": 40,
        "title": "enim quo cumque",
        "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
        quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */

        //1-endpoint ve request body olustur
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", "22");

        //2-expected data olustur
        JSONObject expectedData = TestDataJsonPlaceholder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

        //3-request gonder ve donen response'i kaydet
        Response response = given().spec(specJsonPlaceHolder)
                .when()
                .get("{pp1}/{pp2}");


        //4-assertion
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode()); //bastaki Assert'u silip import ettik
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));
    }
}
