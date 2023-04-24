package tests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PutTest {
    @Test
    public void putTest(){
        JSONObject body = new JSONObject();
        body.put("id",10001);
        JSONObject category=new JSONObject();
        category.put("id",0);
        category.put("name","string");
        body.put("category",category);
        body.put("name","doggie");
        body.put("status","status");

        LinkedHashMap<String, Object> check = new LinkedHashMap<>();
        check.put("id", 0);
        check.put("name", "string");
        RestAssured.given().header("Content-Type", "application/json").body(body.toString())
                .put("https://petstore.swagger.io/v2/pet/").then().assertThat().statusCode(200).body(
                        "id",equalTo(10001),
                        "category", equalTo(check),
                        "name",equalTo("doggie"),
                        "photoUrls",not(equalTo(null)),
                        "tags", not(equalTo(null)),
                        "status", equalTo("status")
                );
    }

    @BeforeTest
    public void putBeforeTest(){
        JSONObject body = new JSONObject();
        body.put("id",10001);
        JSONObject category=new JSONObject();
        category.put("id",0);
        category.put("name","string");
        body.put("category",category);
        body.put("name","doggie");
        body.put("status","status");
        RestAssured.given().header("Content-Type", "application/json").body(body.toString())
                .put("https://petstore.swagger.io/v2/pet/").then().assertThat().statusCode(200);
    }
}
