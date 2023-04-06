package com.homewebdriver.test;

import com.homewebdriver.webpages.NotificationMessagePage;
import com.homewebdriver.webpages.OpenInNewTabPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NotificationMessageTest {
    WebDriver driver;

    String notificationMessageSuccess = "Action successful";
        String notificationMessageFailure = "Action unsuccesful, please try again";

    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void NotificationTest(){
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        String message = notificationMessagePage.getNotification().replace("×","").trim();
        if(message.equals(notificationMessageSuccess) ||message.equals(notificationMessageFailure) ){
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
