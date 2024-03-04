package com.example.restassured;

import com.example.restassured.pojo.User;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpRequests {

    int id;

    @Test(priority = 1)
    void getUser() {

        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();

    }

    @Test(priority = 2)
    void createUser() {
//        Map<String, String> data = new HashMap<>();
//        data.put("name", "john doe");
//        data.put("job", "Techie");

        User user = new User();
        user.setJob("Techie");
        user.setName("John doe");

        id = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
//                .then()
//                    .statusCode(201)
//                    .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "john");
        data.put("job", "Technical");


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 4)
    void deleteuser() {

        given()
                .when()
                .delete("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(204)
                .log().all();

    }
}
