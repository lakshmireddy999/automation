package com.example.restassured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setup(){
    requestSpecification = RestAssured.given()
            .baseUri("https://reqres.in/api/")
            .header("Content-Type","application/json");
    }
}
