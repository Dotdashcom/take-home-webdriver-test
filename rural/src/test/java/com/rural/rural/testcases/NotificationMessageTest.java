package com.rural.rural.testcases;


import com.rural.rural.pages.NotificationMessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class NotificationMessageTest {
    private WebDriver driver;
    private NotificationMessagePage notificationMessagePage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/notification_message_rendered");

        notificationMessagePage = new NotificationMessagePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void NotificationMessage() throws InterruptedException {

       notificationMessagePage.linkClickHere.click();

       String Message=notificationMessagePage.divFlash.getText();

       System.out.println("the message is: "+Message);

       // close the browser
       driver.quit();

    }



}
