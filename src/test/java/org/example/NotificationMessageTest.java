package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BasePage{

    protected NotificationMessagePage notificationMessagePage;
    @BeforeClass
    public void setUp(){
        driver = getDriver();
        notificationMessagePage = PageFactory.initElements(driver, NotificationMessagePage.class);
    }
    @Test
    public void notificationTest(){
        notificationMessagePage.notificationMessageAction();
        Assert.assertTrue(notificationMessagePage.arrayContainsString(notificationMessagePage.notificationMessageArray(),notificationMessagePage.getNotificationMessage()));
    }


    @AfterMethod
    public void endTest(){
        teardown();
    }

}
