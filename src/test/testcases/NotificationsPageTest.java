package com.framework.testcases;
import com.framework.pages.NotificationsPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationsPageTest extends TestBase {
    NotificationsPage notificationsPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the notifications page")
    public void user_is_on_notifications_page() {
        notificationsPage = new NotificationsPage(driver);
        notificationsPage.navigate();
        String actualURL = notificationsPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/notification_message_rendered";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "Notification message is displayed")
    public void user_can_see_notification() {
        notificationsPage = new NotificationsPage(driver);
        notificationsPage.navigate();
        List<String> notificationsList = new ArrayList<>(Arrays.asList("Action successful", "Action unsuccesful, please try again"));
        Boolean isValidNotificationDisplayed = false;
        for (int i = 0; i < 5; i++) {
            notificationsPage.clickLink();
            isValidNotificationDisplayed = notificationsList.contains(notificationsPage.getNotificationMessage());
            Assert.assertTrue(isValidNotificationDisplayed);
        }
    }
	
    @AfterTest
    public void teardown() {
        super.cleanup();
    }
}
