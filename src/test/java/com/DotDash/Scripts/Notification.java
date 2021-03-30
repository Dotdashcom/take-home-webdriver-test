package com.DotDash.Scripts;

import com.DotDash.Pages.NotificationPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class Notification extends basePage {

    @Test(invocationCount = 3)
    public void notification() {
        driver.get(baseURL + "/notification_message_rendered");

        NotificationPage notificationPage = new NotificationPage(driver);

        notificationPage.clklnkClickhere();

        SoftAssert assertion = new SoftAssert();

        assertion.assertTrue(notificationPage.gettxtnotification().contains("Action unsuccesful, please try again")
                || (notificationPage.gettxtnotification().contains("Action successful"))
                || (notificationPage.gettxtnotification().contains("Action Unsuccessful")));

        assertion.assertAll();
    }
}
