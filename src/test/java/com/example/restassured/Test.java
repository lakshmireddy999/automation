package com.example.restassured;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class Test extends  BaseApiTest{

    @org.testng.annotations.Test
    public void get(){
        Response response=requestSpecification.get("users/2");
        System.out.println(response.asPrettyString());
        Assert.assertEquals((int)response.jsonPath().get("data.id"), 2);
    }

    @org.testng.annotations.Test
    public void post(){
        Map<String,Object> requestBody= new HashMap<>();

        requestBody.put("name","john");
        requestBody.put("job","Team Lead");

        Response response = requestSpecification.body(requestBody).post("/users");

        System.out.println(response.asPrettyString());
    }
}
