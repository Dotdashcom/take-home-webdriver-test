package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.NewsTab;
import webdrivertestpages.NotificationMessage;

public class NotificationMessageTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/notification_message_rendered");
    }

    @Test
    public void notificationMsg(){
        NotificationMessage  nm = new NotificationMessage(driver);
        nm.notificationMessage();
        Assert.assertEquals(nm.getMessage(), "Action successful\n" +
                "×");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
