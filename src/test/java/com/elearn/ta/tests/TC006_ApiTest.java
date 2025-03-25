package com.elearn.ta.tests;

import model.api.Users;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class TC006_ApiTest{
    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void verifyResponseStatusCodeIs200(){
        given()
                .when()
                .get(API_URL)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void verifyResponseHeader(){
        given().when().get(API_URL)
                .then()
                .assertThat()
                .contentType(equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void getAvailableDeskList(){
        List<Users> getUsers = given()
                .when()
                .get(API_URL)
                .then()
                .extract()
                .body().jsonPath()
                .getList("users", Users.class);
        assertThat(getUsers.size(), greaterThanOrEqualTo(10));
    }
}
