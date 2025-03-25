package com.elearn.ta.tests;

import page.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.home.HomePageService;

import static com.elearn.ta.driver.DriverSingleton.driver;
import static com.elearn.ta.driver.DriverSingleton.getDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC001_LoginWithEpamAccount extends BaseTestClass{
    @Test(description = "Verify if user can login successfully")
    public void oneCanLogIn(){
        boolean isLogoDisplayed = new HomePageService(getDriver())
                .loginWithEpamAccount(currentUser)
                .isLogoDisplayed();
        Assert.assertTrue(isLogoDisplayed);
        assertThat(isLogoDisplayed, is(true));
    }
}
