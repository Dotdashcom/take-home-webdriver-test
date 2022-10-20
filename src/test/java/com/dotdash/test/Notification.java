package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Notification extends TestBase {

    @Test(testName = "validate notification message displayed")
    public void validateNotificationDisplayed(){
        CommonMethods.navigateTo("notification_message_rendered");
        CommonMethods.click(notificationPage.clickHere);
        Assert.assertEquals(CommonMethods.getText(notificationPage.message),"Action successful\n" +
                "×");
    }
}