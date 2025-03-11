package com.elearn.ta.tests;

import com.elearn.ta.pages.MainPage;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TC002_RepeatBookingFromCompleted extends BaseTestClass {

    @Test(description = "Verify the ability to repeat previous booking from Completed tab")
    public void oneCanRepeatBookingPlace() {
        String messageBlockAfterRepeat = new MainPage(driver.get())
                .loginWithEpamAccount(currentUser)
                .repeatBookingPlace()
                .getToastMessage();
        assertThat(messageBlockAfterRepeat, is(equalTo("The reservation has been created successfully")));
    }
}
