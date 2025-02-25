package com.elearn.ta.tests;

import com.elearn.ta.models.User;
import com.elearn.ta.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_LoginWithEpamAccount extends BaseTestClass{
    @Test
    public void oneCanLogIn(){
        boolean actualResult = new MainPage(driver)
                .loginWithEpamAccount()
                .isLogoDisplayed();
        Assert.assertTrue(actualResult);
    }
}
