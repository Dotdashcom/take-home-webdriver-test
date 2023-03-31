package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessage;

public class NotificationMessageTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/notification_message_rendered");
        NotificationMessage notification = new NotificationMessage(driver);
        notification.click1(driver);
        Assert.assertTrue(notification.click1(driver));
    }
}
