package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceholder {
    protected RequestSpecification specJsonPlaceHolder;  //spec ile basla

    @Before
    public void setUp(){
        specJsonPlaceHolder = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }


}
