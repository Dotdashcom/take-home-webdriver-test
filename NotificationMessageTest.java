import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationMessageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/notification_message_rendered");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNotificationMessage() {
        for (int i = 0; i < 5; i++) { 
            WebElement link = driver.findElement(By.linkText("Click here"));
            link.click();
            WebElement message = driver.findElement(By.id("flash")); 
            String messageText = message.getText(); 
            Assert.assertTrue(messageText.contains("Action Successful") ||
                              messageText.contains("Action unsuccessful, please try again") ||
                              messageText.contains("Action Unsuccessful")); 
        }
    }
}
