package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotificationMessagePage;

import static org.testng.Assert.assertTrue;

public class NotificationMessageTest extends BaseTest{
    @Test
    public void verifyNotificationMessages() {
        HomePage homePage = new HomePage(driver);
        NotificationMessagePage notificationMessage = homePage.clickNotification();
        assertTrue(notificationMessage.clickButtonMultipleTimes());
    }
}
