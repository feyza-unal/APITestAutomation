import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; // * matchers classindaki tum methodlari import etmek icin

public class C09_GetBodyTekrarlardanKurtulma {
    @Test
    public void test01() {
        /*
https://restful-booker.herokuapp.com/booking/10 url’ine bir
GET request gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Mark",
ve "lastname“in, "Jackson",
ve "totalprice“in, 1000den kucuk oldugunu ,
ve "depositpaid“in, false,
ve "additionalneeds“in, bos birakilmadigini
 test edin
         */

        //1- end point ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- expected data olustur
        //3- request gonderip donen response'i kaydet
        Response response = given().when().get(url);

        //4- assertion
        //response.prettyPrint();

        /* 2. YONTEM ILE YAPMAK ICIN YORUMA ALDIM
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark"))
                .body("lastname", Matchers.equalTo("Jackson"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(false))
                .body("additionalneeds",Matchers.notNullValue());
             */

        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mark"), // Matchers'i silip equalTo'yu import ediyoruz
                        "lastname", equalTo("Jackson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",notNullValue());





    }
}
