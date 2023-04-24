package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteTest {
    @Test
    public void deleteTest(){
        RestAssured.
                when().delete(" https://petstore.swagger.io/v2/pet/10001").
                then().assertThat().statusCode(200);
        RestAssured.
                when().get(" https://petstore.swagger.io/v2/pet/10001").
                then().assertThat().statusCode(404);
    }
}
