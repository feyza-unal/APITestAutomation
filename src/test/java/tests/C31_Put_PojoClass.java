package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJasonPlaceholder;
import testDatalari.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {
       /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body : // expected data
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01() {
        //1-request body ve url olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);

        PojoJasonPlaceholder requestBodyPojo = new PojoJasonPlaceholder("Ahmet","Merhaba",10,70);

        //2-expected data olustur
        PojoJasonPlaceholder expectedDataPojo = new PojoJasonPlaceholder("Ahmet","Merhaba",10,70);

        //3-request gonder ve response'i kaydet
        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("{pp1}/{pp2}");
//response.prettyPrint();

        //4-assertion
        // expected data (Pojo) <====> response (Pojo)
        // expectedDataPojo             responsePojo
        PojoJasonPlaceholder responsePojo = response.as(PojoJasonPlaceholder.class); //pojoya cevirdik

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        //response body'nin ayni oldugunu test et
        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());


    }
}
