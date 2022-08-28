package com.project.pom.test;

import com.project.pom.page.Login;
import com.project.pom.page.NotificationMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NotificationMessageTest {

    private WebDriver driver;
    NotificationMessage notificationMessage;

    @Before
    public void setUp(){
        notificationMessage = new NotificationMessage(driver);
        driver = notificationMessage.chromeDriverConnection();
        notificationMessage.visit("/notification_message_rendered");
    }

    @Test
    public void loginSuccess(){
        assertTrue(notificationMessage.notification());
    }

    @After
    public void end(){ driver.quit(); }
}
