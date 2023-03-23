package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;
public class Notification extends Constants{

    @Test
    public void notificationPractice() {
        driver.get("http://localhost:7080/notification_message_rendered");

        driver.findElement(By.linkText("Click here")).click();

        String text = driver.findElement(By.id("flash-messages")).getText().trim();
        sa.assertTrue(text.contains("Action"));
        sa.assertAll();
    }
}
