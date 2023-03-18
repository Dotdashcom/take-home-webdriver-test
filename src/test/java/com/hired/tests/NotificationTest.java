package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.NotificationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationTest extends BasePage {
    public WebDriver driver;
    NotificationPage notificationPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("notificationsUrl"));
    }

    @Test
    public void validateFileUpload() {

        notificationPage= new NotificationPage(driver);
        notificationPage.verifyNotification("Action successful", "Action unsuccesful, please try again");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
