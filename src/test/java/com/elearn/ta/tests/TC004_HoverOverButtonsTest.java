package com.elearn.ta.tests;

import page.home.HomePage;
import org.testng.annotations.Test;
import service.home.HomePageService;

import static com.elearn.ta.driver.DriverSingleton.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TC004_HoverOverButtonsTest extends BaseTestClass{
    @Test(description = "Verify that hint text appears for Add Colleagues button")
    public void hoverTextDisplayedForButton(){
        String actualBtnHoverText = new HomePageService(getDriver())
                .loginWithEpamAccount(currentUser)
                .hoverOverAddColleaguesBtn()
                .getHoverOverBtnText();
        assertThat(actualBtnHoverText, is(equalTo("Favorite places are shown in Recommendations widget")));
    }
}
