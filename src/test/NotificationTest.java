package src.test;

import org.testng.annotations.Test;
import src.main.pages.*;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class NotificationTest extends BaseTest {



    private NotificationMessagePage notificationMessagePage;

    @Test
    public void notificationMessageTest() {
        notificationMessagePage = Browser.open(baseURL + "notification_message_rendered", NotificationMessagePage.class);

        for (int i = 0; i < 3; ++i) {
            notificationMessagePage.loadNewMessage();
            assertTrue(notificationMessagePage.isFlashMessageExpected());
        }
    }

}
