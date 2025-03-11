package com.elearn.ta.tests;

import com.elearn.ta.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC001_LoginWithEpamAccount extends BaseTestClass{
    @Test(description = "Verify if user can login successfully")
    public void oneCanLogIn(){
        boolean isLogoDisplayed = new MainPage(driver.get())
                .loginWithEpamAccount(currentUser)
                .isLogoDisplayed();
        Assert.assertTrue(isLogoDisplayed);
        assertThat(isLogoDisplayed, is(true));
    }
}
