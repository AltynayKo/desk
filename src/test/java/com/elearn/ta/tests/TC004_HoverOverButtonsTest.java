package com.elearn.ta.tests;

import com.elearn.ta.pages.MainPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TC004_HoverOverButtonsTest extends BaseTestClass{
    @Test(description = "Verify that hint text appears for Add Colleagues button")
    public void hoverTextDisplayedForButton(){
        String actualBtnHoverText = new MainPage(driver.get())
                .loginWithEpamAccountActPage(currentUser)
                .hoverOverAddColleaguesBtn()
                .getHoverOverBtnText();
        assertThat(actualBtnHoverText, is(equalTo("Favorite places are shown in Recommendations widget")));
    }
}
