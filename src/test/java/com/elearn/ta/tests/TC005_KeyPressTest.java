package com.elearn.ta.tests;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.elearn.ta.pages.MainPage;
import org.testng.annotations.Test;

public class TC005_KeyPressTest extends BaseTestClass{
    @Test(description = "Verify that Search block is displayed when pressing Enter key")
    public void oneCanSearchPeople(){
        boolean isPeopleSearchBlockDisplayed = new MainPage(driver.get())
                .loginWithEpamAccountActPage(currentUser)
                .searchPeople("hello")
                .isPeopleSearchResultBlockDisplayed();
        assertThat(isPeopleSearchBlockDisplayed, is(true));
    }
}
