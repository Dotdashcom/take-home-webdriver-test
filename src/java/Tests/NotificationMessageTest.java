package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;


public class NotificationMessageTest extends DriverUtilities {

    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/notification_message_rendered");
    }
    @Test
    public void notificationMessage() throws InterruptedException {
        WebDriver driver = getDriver();
        for (int i = 0; i <= 10; i++) {
            driver.findElement(By.xpath("//a[contains(text(),\"Click here\")]")).click();
            i++;
            Thread.sleep(1000);

            WebElement message = driver.findElement(By.xpath("//*[@id='flash']"));
            Assert.assertTrue(message.getText().contains("Action successful")
                    || message.getText().contains("Action unsuccesful, please try again")
                    || message.getText().contains("Action Unsuccessful"));
        }
    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}
