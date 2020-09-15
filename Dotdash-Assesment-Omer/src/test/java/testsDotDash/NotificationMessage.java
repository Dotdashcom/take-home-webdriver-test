package testsDotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class NotificationMessage {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/notification_message_rendered");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void notificationMessageTest(){

        WebElement clickHere = Driver.get().findElement(By.cssSelector("a[href='/notification_message']"));
        clickHere.click();

        String actualNotification = Driver.get().findElement(By.id("flash")).getText();


        Assert.assertTrue(actualNotification.contains("Action successful") || actualNotification.contains("Action unsuccesful, please try again"));

    }
}
