package com.elearn.ta.tests;

import model.api.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class TC006_ApiTest{
    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void verifyResponseStatusCodeIs200(){
        int actualStatusCode = given().when().get(API_URL)
                .statusCode();
        assertThat(actualStatusCode, is(200));
    }
    @Test
    public void verifyResponseHeader(){
        String actualContentType = given().when().get(API_URL)
                .getContentType();
        assertThat(actualContentType, equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void getAvailableDeskList(){
        List<Users> getUsers = given()
                .when()
                .get(API_URL)
                .then()
                .log().all().extract()
                .body().jsonPath()
                .getList("users", Users.class);
        assertThat(getUsers.size(), greaterThanOrEqualTo(10));
    }
}
