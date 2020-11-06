package Tests;

import PageRepositories.NotificationMessage;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class NotificationMessageTest extends BaseTest {
    @Test(priority=1)
    @Description("Test Notification Message Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Notification Message")
    public void notification_message_test() {
        NotificationMessage notificationMessage = new NotificationMessage(driver);

        notificationMessage.navigate_to_notification_message_page(base_url);
        notificationMessage.validate_notification_message_page_header();
        for (int itt = 0; itt <= 5; itt++) {
            notificationMessage.click_for_new_message();
            notificationMessage.check_notice_message();
        }
    }
}
