package com.elearn.ta.tests;

import page.home.HomePage;
import org.testng.annotations.Test;
import service.home.HomePageService;

import static com.elearn.ta.driver.DriverSingleton.driver;
import static com.elearn.ta.driver.DriverSingleton.getDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC002_RepeatBookingFromCompleted extends BaseTestClass {

    @Test(description = "Verify the ability to repeat previous booking from Completed tab")
    public void oneCanRepeatBookingPlace() {
        String messageBlockAfterRepeat = new HomePageService(getDriver())
                .loginWithEpamAccount(currentUser)
                .repeatBookingPlace()
                .getToastMessage();
        assertThat(messageBlockAfterRepeat, is(equalTo("The reservation has been created successfully")));
    }
}
