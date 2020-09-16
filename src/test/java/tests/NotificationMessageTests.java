package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class NotificationMessageTests extends TestBase {

    /**
     * 18. Notification Message
     * <p>
     * Test clicks on the Click Here link a multiple times.
     * Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
     */

    @Test
    @DisplayName("Test clicks on the Click Here link a multiple times and verifies messages")
    public void notificationMessageTest() {
        Driver.getDriver().findElement(By.linkText("Notification Messages")).click();
        List<String> expectedMessages = List.of("Action unsuccessful, please try again", "Action successful", "Action Unsuccessful");

        for (int index = 0; index < 5; index++) {
            Driver.getDriver().findElement(By.linkText("Click here")).click();
            WebElement msgElement = Driver.getDriver().findElement(By.id("flash"));
            String actual1 = msgElement.getText().replace("×", "").trim();
            Assertions.assertTrue(expectedMessages.contains(actual1), "Message is not correct!");
        }
    }


}
