package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.NotificationMessagesPage;
import org.testng.annotations.Test;

public class NotificationMessageTest_18 extends BaseClass {

    @Test
    public void NotificationMessageTest() {
        driver.get(baseURL);
        NotificationMessagesPage notificationPage = new NotificationMessagesPage(driver);

        notificationPage.clickNotificationPageLink();
        notificationPage.clickLoadNewMessage();
    }
}
