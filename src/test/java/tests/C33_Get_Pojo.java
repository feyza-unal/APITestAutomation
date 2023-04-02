package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoDummyExampleData;
import pojos.PojoDummyExampleResponse;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
public class C33_Get_Pojo extends BaseUrlDummyExample {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
	Response Body
	// expected data
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

    @Test
    public void test01() {

        //1-req url ve body olustur
        specDummyExample.pathParams("pp1","employee","pp2",3);

        //2-expected data olustur
        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3,"Ashton Cox",86000,66,"");
        PojoDummyExampleResponse expectedResponseBody = new PojoDummyExampleResponse("success",dataPojo,"Successfully! Record has been fetched.");

        //3-req gonder ve res kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");

        //System.out.println(expectedResponseBody);
        /*
        pojos.PojoDummyExampleResponse@6009bea[
            status=success,
            data=pojos.PojoDummyExampleData@7bc6d27a[
                id=3,
                employeeName=Ashton Cox,
                employeeSalary=86000,
                employeeAge=66,
                profileImage=],
             message=Successfully! Record has been fetched.]*/
//        ==>data icerisindeki variable isimleri farkli (hazir cevirici yuzunden)

        //4-assertion
        // expectedResponseBody (Pojo) <=====> Response
        // hazir ceviriciler attribute isimlerini degistirdiginden, response'i Pojo'ya convert edemedik
        // Bu durumda testimize devam etmek icin response'i Jsonpath'e cevirebiliriz
        // expectedResponseBody (Pojo) <=====> ResponseJsonPath

        JsonPath responseJP = response.jsonPath();


        assertEquals(expectedResponseBody.getMessage(),responseJP.getString("message"));
        assertEquals(expectedResponseBody.getStatus(),responseJP.getString("status"));

        assertEquals(expectedResponseBody.getData().getId(),
                responseJP.get("data.id"));
        assertEquals(expectedResponseBody.getData().getEmployeeName(),
                responseJP.get("data.employee_name"));
        assertEquals(expectedResponseBody.getData().getEmployeeAge(),
                responseJP.get("data.employee_age"));
        assertEquals(expectedResponseBody.getData().getEmployeeSalary(),
                responseJP.get("data.employee_salary"));
        assertEquals(expectedResponseBody.getData().getProfileImage(),
                responseJP.get("data.profile_image"));









    }
}
// google-> json to pojo --> https://www.jsonschema2pojo.org
//  # package ve class ismi gir.(orn: class-> PojoDummyExampleResponse)
//  # expected datayi yapistir
/*
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

//  # source type-> json
//  # annotation ve validation -> none
//  # include getter setter, consutructor, toString
//  # bi sonucu bazen verip bazen vermiyosa -> allow additional properties secebiliriz
//  #  preview