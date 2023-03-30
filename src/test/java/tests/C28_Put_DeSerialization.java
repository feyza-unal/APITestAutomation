package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import org.junit.Test;

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

        //2-expected data olustur
        //3-request gonder ve response kaydet
        //4-assertion
        //    expected Response body  <=====> response
        //        Map                         Response

    }
}

//JAVA OBJELERINI API SORGULARI YAPMAK UZERE JSON OBJESINE CEVIRMEYE SERIALIZATION DENIR
//JSON OBJESINI JAVA OBJESINE CEVIRMEYE ISE DE-SERIALIZATION DENIR