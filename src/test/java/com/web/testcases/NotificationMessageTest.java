package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.NotificationMessagePage;

public class NotificationMessageTest extends TestBase{

    NotificationMessagePage notificationMessagePage;

    public NotificationMessageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/notification_message_rendered");
        notificationMessagePage = new NotificationMessagePage();
    }

    @Test()
    public void verifyNotificationMessage() {

        for(int i=1;i<10;i++) {
            notificationMessagePage.linkTextClick();
        }

        if(notificationMessagePage.getFlashElementText().contains("successful")){
            Assert.assertEquals(notificationMessagePage.getFlashElementText(),"Action successful\n"+"×");
        }else if (notificationMessagePage.getFlashElementText().contains("please")){
            Assert.assertEquals(notificationMessagePage.getFlashElementText(),"Action unsuccesful, please try again\n"+"×");
        }
      }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}