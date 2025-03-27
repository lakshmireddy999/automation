package com.example.restassured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SampleTest extends BaseApiTest {

    @Test
    public void get() {
        Response response = requestSpecification.get("users/2");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void post() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "john");
        requestBody.put("job", "Engineer");

        Response response = requestSpecification.body(requestBody).post("/users");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void getListUsers(){
        Response response = requestSpecification.queryParams("page",2).get("users");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);

        List<Map<String, Object>> users = response.jsonPath().getList("data");
        for (Map<String, Object> user : users) {
            int id = (int) user.get("id");
            String email = (String) user.get("email");
            String firstName = (String) user.get("first_name");
            String lastName = (String) user.get("last_name");

            System.out.println("User ID: " + id);
            System.out.println("Email: " + email);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("----------------------");

            Assert.assertNotNull(email, "Email should not be null!");
        }
    }
}
