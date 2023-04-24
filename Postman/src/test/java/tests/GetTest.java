package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetTest {

    @Test
    public void getTest(){
        LinkedHashMap<String, Object> check = new LinkedHashMap<>();
        check.put("id", 0);
        check.put("name", "string");
        RestAssured.
                when().get(" https://petstore.swagger.io/v2/pet/10001").
                then().assertThat().statusCode(200).
                body("id",equalTo(10001),
                        "category",equalTo(check),
                        "name",equalTo("doggie"),
                        "photoUrls",not(equalTo(null)),
                        "tags", not(equalTo(null)),
                        "status", equalTo("status")

                );
    }

}
