package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDataDummyExample;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C26_GetTestDataKullanimi extends BaseUrlDummyExample {
    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.
          Expected Response Body
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */

        // 1- endpoint ve request body olustur
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2- expected data olustur


        // 3- request gonder ve donen response'i kaydet


        // 4- assertion
        //   Expected data : JSONObject
        //   response : JsonPath











        }
}
