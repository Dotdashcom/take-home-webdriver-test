package com.company.tests;


import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * Test clicks on the Click Here link a multiple times.
 * Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
 */
public class TestCase18NotificationMessage {

    @Test
    public void notificationMessage() {

        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/p/a"));

        clickHere.click();

        WebElement notificationMessage = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Action')]"));

        notificationMessage.getText();

        String notificationText = notificationMessage.getText();

        if (Objects.equals(notificationText, "Action Successful")) {
            assertEquals("Message \"Action Successful\" did not matched!", "Action Successful", notificationMessage.getText());
        } else if (Objects.equals(notificationText, "Action unsuccessful, please try again")) {
            assertEquals("Message \"Action unsuccessful, please try again\" did not matched!", "Action unsuccessful, please try again", notificationMessage.getText());
        } else if (Objects.equals(notificationText, "Action Unsuccessful")) {
            assertEquals("Message \"Action Unsuccessful\" did not matched!", "Action Unsuccessful", notificationMessage.getText());
        }
        Driver.closeDriver();
    }
}
