package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class NotificationMessage {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void NotificationMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");
        String[] expected = {"Action successful", "Action unsuccesful, please try again"};
        for (int i = 1; i <= 2; i++) {
            Driver.getDriver().findElement(By.linkText("Click here")).click();
            String actual = Driver.getDriver().findElement(By.id("flash-messages")).getText();
            assertNotEquals(expected[i - 1], actual);
        }
    }
}
