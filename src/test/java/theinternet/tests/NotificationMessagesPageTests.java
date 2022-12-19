package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.NotificationMessagesPage;

public class NotificationMessagesPageTests extends BaseTest {
    NotificationMessagesPage notificationMessagesPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToNotificationMessagesPage();
        notificationMessagesPage = new NotificationMessagesPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(notificationMessagesPage.validatePageLanding(), "Notification message page loaded");
    }

    @Test(priority = 1)
    public void testNotificationMessage() throws InterruptedException {
        Integer clickCount = 3;

        for (int i = 0; i < clickCount; i++) {
            notificationMessagesPage.generateNotification();
            String notificationMessage = notificationMessagesPage.getNotificationMessage();
            String possibleText1 = "Action unsuccesful, please try again";
            String possibleText2 = "Action successful";

            Assert.assertTrue(notificationMessage.contains(possibleText1)
                            || notificationMessage.contains(possibleText2),
                    "Did not find possible notification text"
            );
        }
    }
}
