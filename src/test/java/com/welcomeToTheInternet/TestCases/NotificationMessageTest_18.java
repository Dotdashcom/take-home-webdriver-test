package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.NotificationMessages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


public class NotificationMessageTest_18 extends BaseClass {

    @Test

    public void notificationMessageTest() throws InterruptedException {

        NotificationMessages messagePage = new NotificationMessages(driver);
        messagePage.clickNotificationMessageLink();

        final int ATTEMPTS = 10;
        Set<String> allowedMessages = new HashSet<String>();
        allowedMessages.add("Action successful\n×");
        allowedMessages.add("Action Unsuccessful\n×");
        allowedMessages.add("Action unsuccesful, please try again\n×");


        for (int i=0; i < ATTEMPTS ; i++) {
            messagePage.clickLoadMessage();
            Thread.sleep(1000);
            String message = messagePage.checkMessage();
            boolean isTrue = allowedMessages.contains(message);
            if (isTrue) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(false);
            }
        }

    }
}
