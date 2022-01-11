package com.example.demo;

import pages.NotificationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class T18NotificationMessage extends TestMain{
    NotificationMessagePage notificationMessagePage;
    List<String> messages;

    @Test
    public void testClickMultipleTimes()  {
        notificationMessagePage = new NotificationMessagePage(driver);
        messages = Arrays.asList("Action successful\n×", "Action unsuccesful, please try again\n×", "Action unsuccessful\n×");
        notificationMessagePage.clickText();
        String message1 = notificationMessagePage.getMessage();
        Assert.assertTrue(messages.contains(message1));
        notificationMessagePage.clickText();
        String message2 = notificationMessagePage.getMessage();
        Assert.assertTrue(messages.contains(message2));
        notificationMessagePage.clickText();
        String message3 = notificationMessagePage.getMessage();
        Assert.assertTrue(messages.contains(message3));
    }
}

