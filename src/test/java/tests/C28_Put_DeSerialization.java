package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceholder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

//gson kutuphanesini pom'a ekledik
public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz
        Request Body
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
        Expected Response Body:
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */

    @Test
    public void test01() {
        //1-endpoint ve request body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);

//        Request bodysini Map olarak olusturalim -> testdata classinda
        Map<String,Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap();
//        yazdirdigimizda jsonobject ile aradaki var map'te '=' , cift tirnak yok
//        jsonobject'de ':'

        //2-expected data olustur
        Map<String, Object> expectedData = TestDataJsonPlaceholder.bodyOlusturMap();

        //3-request gonder ve response kaydet
        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .put("{pp1}/{pp2}");

        //4-assertion
        //    expected Response body  <=====> response
        //        Map                         Response
        // Assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (De-Serialization)
        Map<String,Object> responseMap = response.as(HashMap.class);
        //System.out.println("response map: "+responseMap); //{id=70.0, title=Ahmet, body=Merhaba, userId=10.0}

        // expectedData (Map) <===> responseMap(Map)

        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));
//        json obje olusturmadan request body ve expected data olarak map olusturduk
//        expected data map oldugu icin, donen response'i da karsilastirabilmek icin(java objesi olarak)
//        response'i da map'a cevirdik ==> Map<String,Object> responseMap = response.as(HashMap.class);

    }
}

//JAVA OBJELERINI API SORGULARI YAPMAK UZERE JSON OBJESINE CEVIRMEYE SERIALIZATION DENIR
//JSON OBJESINI JAVA OBJESINE CEVIRMEYE ISE DE-SERIALIZATION DENIR