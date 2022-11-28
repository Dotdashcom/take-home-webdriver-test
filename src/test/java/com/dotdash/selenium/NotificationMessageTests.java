package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.NotificationMessagePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class NotificationMessageTests extends SetUpTearDown {
    HomePage homePage;
    NotificationMessagePage notificationMessagePage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        notificationMessagePage = new NotificationMessagePage(driver);
    }

    @Test
    public void verifyDifferentMessageInBanner() {
        String[] messages = {"Action successful","Action unsuccesful, please try again","Action Unsuccessful"};
        homePage.clickNotificationMessageLink();
        for (int i=0;i<7;i++){
            notificationMessagePage.clickOnLink();
            Assert.assertTrue(Arrays.toString(messages).contains(notificationMessagePage.getMessageBanner()));
        }
    }
}
