package com.example.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Get extends BaseApiTest{

    @Test
    public void get() {
        RequestSpecification requestSpecification1 = RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/todos");

        Response response = requestSpecification1.get();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        List<Object> toDos = response.jsonPath().getList("$");
        Assert.assertTrue(toDos.size() > 0);

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getInt("[0].userId"), 1);

        // Extract the list of todos
        List<Map<String, Object>> todos = jsonPath.getList("$");

        // Iterate through each object using a for loop
        for (Map<String, Object> todo : todos) {
            // Extract fields from each object
            int id = (int) todo.get("id");
            String title = (String) todo.get("title");
            boolean completed = (boolean) todo.get("completed");

            // Print each todo
            System.out.println("Todo ID: " + id);
            System.out.println("Title: " + title);
            System.out.println("Completed: " + completed);
            System.out.println("----------------------");

            // Add assertions for validation
            Assert.assertNotNull(title, "Title should not be null!");
        }
    }
}
