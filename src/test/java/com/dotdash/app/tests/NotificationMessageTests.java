package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.LoginPage;
import com.dotdash.app.pageobjects.NotificationMessagePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NotificationMessageTests extends BaseTest {
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
