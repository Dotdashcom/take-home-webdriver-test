package com.ddm.testcases;

import com.ddm.pageobjects.NotificationMessagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NotificationMessageTests extends BaseTestClass {

    protected NotificationMessagesPage notificationMessagesPage;

    @BeforeMethod
    public void setUpMethodNotifications() {
        notificationMessagesPage = landingPage.goTo("/notification_message_rendered", NotificationMessagesPage.class);
    }
    @Test
    public void NotificationMessageTest() {
        String notification = notificationMessagesPage.getGeneratedNotification();

        SoftAssert sf = new SoftAssert();
        sf.assertTrue(notification.contains("Action unsuccesful, please try again") ||
                notification.contains("Action successful"), "Unexpected notification is generated.");

        // Generate notifications until a unique notification is generated
        for(; ;) {
            String newNotification = notificationMessagesPage.getGeneratedNotification();
            if(!newNotification.equals(notification)) {
                sf.assertTrue(notification.contains("Action unsuccesful, please try again") ||
                        notification.contains("Action successful"), "Unexpected notification is generated.");
                break;
            }
        }
        sf.assertAll();
    }
}
