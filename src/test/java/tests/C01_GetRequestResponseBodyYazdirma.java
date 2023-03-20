package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequestResponseBodyYazdirma {

    @Test
    public void get01() {

        //https://restful-booker.herokuapp.com/booking/10 url'ine git
        // bit GET req. gonderdigimizde donen res. yazdir

        // 1- Request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirlama

        // 3- Request gonderip, donen response'u kaydetme
        Response response = given().when().get(url);
        response.prettyPrint(); // response body'i yazdirma

        // 4- Assertion

    }
}

/* Response classinda obje olusturma
    # Response response = given().when().get(url);
    # given: teste baslarken bize verilen baslangic degerleri
    # when: testte gerceklestirdigimiz islemler
    # then: response degerlerini degerlendirmek icin yapilan islemler
    # and: birbirine bagli islemler

 */
