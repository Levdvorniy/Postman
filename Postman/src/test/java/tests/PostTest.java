package tests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PostTest {

    @Test
    public void postTest(){

        JSONObject body = new JSONObject();
        body.put("id",11111);
        JSONObject category=new JSONObject();
        category.put("id",12);
        category.put("name","sss");
        body.put("category",category);
        body.put("name","bobik");
        body.put("status","available");
        LinkedHashMap<String, Object> check = new LinkedHashMap<>();
        check.put("id", 12);
        check.put("name", "sss");


        RestAssured.given().header("Content-Type", "application/json").body(body.toString())
                .post("https://petstore.swagger.io/v2/pet/").then().assertThat().statusCode(200)
                .body(
                        "id",equalTo(11111),
                        "category",equalTo(check),
                        "name",equalTo("bobik"),
                        "photoUrls",not(equalTo(null)),
                        "status", equalTo("available"));

    }


}


