package com.elearn.ta.tests;
import static com.elearn.ta.driver.DriverSingleton.getDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import page.home.HomePage;
import org.testng.annotations.Test;
import service.home.HomePageService;

public class TC005_KeyPressTest extends BaseTestClass{
    @Test(description = "Verify that Search block is displayed when pressing Enter key")
    public void oneCanSearchPeople(){
        boolean isPeopleSearchBlockDisplayed = new HomePageService(getDriver())
                .loginWithEpamAccount(currentUser)
                .searchPeople("hello")
                .isPeopleSearchResultBlockDisplayed();
        assertThat(isPeopleSearchBlockDisplayed, is(true));
    }
}
