package com.elearn.ta.tests;

import page.home.HomePage;
import org.testng.annotations.Test;
import service.home.HomePageService;

import static com.elearn.ta.driver.DriverSingleton.driver;
import static com.elearn.ta.driver.DriverSingleton.getDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC003_LogoutFromEpamAccount extends BaseTestClass{
    private String PROMO_PAGE_URL = "https://access.epam.com/auth/realms/plusx/protocol/openid-connect/logout?redirect_uri=https://desk.epam.com/promo";

    @Test
    public void oneCanLogOut(){
        String actualPageUrl = new HomePageService(getDriver())
                .loginWithEpamAccount(currentUser)
                .logOut()
                        .getPageUrl();
        assertThat(actualPageUrl, is(equalTo(PROMO_PAGE_URL)));
    }
}
