import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.NotificationMessagePage;

import java.util.HashSet;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class NotificationMessage {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/notification_message_rendered");
    }

    @Test(testName = "Notification Message")
    public void clickManyTimesToGenerateMessages() {
        final int Count = 5;
        NotificationMessagePage page = new NotificationMessagePage(driver);
        Set<String> allowedMessages = new HashSet<String>();
        allowedMessages.add("Action successful\n×");
        allowedMessages.add("Action Unsuccessful\n×");
        allowedMessages.add("Action unsuccesful, please try again\n×");

        for (int i = 0; i < Count; i++) {
            page.displayNewMessage();
            String flashMessage = page.getFlashMessage();
            assertTrue("No Message displayed", allowedMessages.contains(flashMessage));
        }
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
