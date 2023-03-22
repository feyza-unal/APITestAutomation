package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak “firstname” degeri “Susan” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
         */

        //1-endpoint ve request body olustur
        specHerokuapp.pathParam("pp1", "booking").queryParam("firstname","Susan");

        //2-expected data olustur
        //3-request gonder ve donen response'i kaydet
        Response response = given()
                            .when().spec(specHerokuapp)
                            .get("/{pp1}");

        //4-assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2)); //once yazdirip 2 oldugunu gorduk
    }
}
