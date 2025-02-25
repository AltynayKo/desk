package com.elearn.ta.tests;

import com.elearn.ta.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_LogoutFromEpamAccount extends BaseTestClass{

    @Test
    public void oneCanLogOut(){
        String actualResult = new MainPage(driver)
                .loginWithEpamAccount()
                .logOut()
                .openPage()
                .getCurrentPageUrl();
        Assert.assertTrue(actualResult.contains("https://access.epam.com/auth"));
    }
}
