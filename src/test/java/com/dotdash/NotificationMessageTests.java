package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.NotificationMessagePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class NotificationMessageTests extends BaseTest {

    @Test
    public void shouldValidateNotificationMessage() {
        String successAction = "Action successful";
        String tryAgainMessage = "Action unsuccesful, please try again";
        String unsuccesfulAction = "Action Unsuccessful";
        NotificationMessagePage notificationMessagePage = GeneratePage.notificationMessagePage().goToNotificationMessagePage().displayNotification();

        assertThat(notificationMessagePage.getAlertMessage(), is(anyOf(equalTo(successAction), equalTo(tryAgainMessage), equalTo(unsuccesfulAction))));
    }
}
