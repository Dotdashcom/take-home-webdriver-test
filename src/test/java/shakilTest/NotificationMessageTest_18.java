package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationMessageTest_18 extends TestBase {

    String message1 = "Action unsuccesful, please try again";
    String message2 = "Action successful";
    String message3 = "Action unsuccessful";

    @Test
    public void testNotificationMessage() {

        driver.get("https://the-internet.herokuapp.com/notification_message");

        WebElement link = driver.findElement(By.xpath("/html//div[@id='content']//a[@href='/notification_message']"));
        link.click();

        WebElement messageElement = driver.findElement(By.xpath("/html//div[@id='flash']"));

        String messageText = messageElement.getText().replaceAll("[^\\p{Print}\\t\\n]", "");

        System.out.println("data received: " + messageText);

        List<String> expectedMessages = Arrays.asList(message1, message2, message3);

        boolean isMessageMatched = false;
        for (String expectedMessage : expectedMessages) {
            if (expectedMessage.equals(messageText)) {
                isMessageMatched = true;
                System.out.println("Test passed! The message '" + messageText + "' matches the expected message: " + expectedMessage);
                break;
            }
        }

        if (!isMessageMatched) {
            System.out.println("Test failed! The message '" + messageText + "' does not match any of the expected messages.");
            Assert.fail();
        }
    }
}



// click here link xpath /html//div[@id='content']//a[@href='/notification_message']
        //WebElement messageElement = driver.findElement(By.xpath("/html//div[@id='flash']")); 