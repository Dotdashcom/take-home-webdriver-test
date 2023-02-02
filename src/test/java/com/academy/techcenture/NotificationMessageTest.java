package com.academy.techcenture;

import com.academy.techcenture.pages.NotificationMessagePage;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseClassTest {

    @Test
    public void notificationMessageTest(){
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver, softAssert);
        notificationMessagePage.navigateTo("/notification_message_rendered");
        notificationMessagePage.verifyNotificationMessage();
    }

}
