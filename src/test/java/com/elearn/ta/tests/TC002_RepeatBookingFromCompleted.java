package com.elearn.ta.tests;

import com.elearn.ta.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_RepeatBookingFromCompleted extends BaseTestClass {

    @Test
    public void oneCanRepeatBookingPlace() {
        MainPage actualResult = new MainPage(driver)
                .loginWithEpamAccount()
                .repeatBookingPlace();
        Assert.assertEquals(actualResult.getToastMessage(), "The reservation has been created successfully");
    }
}
