package com.test.tests;

import org.junit.jupiter.api.Test;
import com.test.pages.NotificationMessagePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessageTest extends TestBase {

    @Test
    public void testNotificationMessage() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        for (int i = 0; i < 5; i++) {
            notificationMessagePage.clickClickHereLink();
            assertTrue(notificationMessagePage.isMessageDisplayed());
        }
    }
}
