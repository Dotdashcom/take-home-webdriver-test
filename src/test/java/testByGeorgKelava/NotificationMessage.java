package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class NotificationMessage {
    public NotificationMessage() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "notification_message_rendered");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @Test
    public void notificationMessageTest() {
        WebElement clickLocation = Driver.get().findElement(By.cssSelector("a[href='/notification_message']"));
        clickLocation.click();
        String actualNotification = Driver.get().findElement(By.id("flash")).getText();
        Assert.assertTrue(actualNotification.contains("Action successful") || actualNotification.contains("Action unsuccesful, please try again"));
    }
}
