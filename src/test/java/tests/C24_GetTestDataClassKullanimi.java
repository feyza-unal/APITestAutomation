package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceholder;

public class C24_GetTestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {
    /*
    https://jsonplaceholder.typicode.com/posts/40 url'ine bir
    GET request yolladigimizda donen response’in status kodunun
    200 ve response body’sinin asagida verilen ile ayni oldugunutest ediniz
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
        JSONObject expectedData = TestDataJsonPlaceholder.responseJsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");
        //3-request gonder ve donen response'i kaydet
        //assertion

    }
}
