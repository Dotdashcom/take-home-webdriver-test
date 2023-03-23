package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest_13 extends TestBase {

    @Test
    public void testIframeInteraction() {
        driver.get("http://localhost:7080/iframe");

        // Switch to the iframe
        driver.switchTo().frame("mce_0_ifr");

        // Close the first notification popup
        WebElement dismissButton = driver.findElement(By.cssSelector(".tox-notification__dismiss[width]"));
        dismissButton.click();

        // Type some text in the iframe
        WebElement editableArea = driver.findElement(By.xpath("//body[@id='tinymce']/p[.='Your content goes here.']"));
        editableArea.clear();
        editableArea.sendKeys("Hello, world!");

        // Close the second notification popup
        WebElement newNotification = driver.findElement(By.xpath("/html//div[@class='tox-notifications-container']/div[@role='alert']"));
        WebElement newNotificationCloseButton = newNotification.findElement(By.cssSelector(".tox-notification__dismiss[width]"));
        newNotificationCloseButton.click();

        // Switch back to the main frame
        driver.switchTo().defaultContent();

        // Verify that the typed text is as expected
        String expectedText = "Hello, world!";
        WebElement resultElement = driver.findElement(By.xpath("//div[@id='content']//p"));
        String actualText = resultElement.getText();
        Assert.assertEquals(actualText, expectedText, "The typed text is not as expected");
    }
}
