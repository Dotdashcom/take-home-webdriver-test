package tests;

import enums.Messages;
import enums.Pages;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import utilities.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationMessageTest extends TestBase {

    @Test(description = "Notification Message Test")
    public void notificationMessageTest() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
        BrowserUtils.openPage(driver, Pages.NOTIFICATION_MESSAGE_PAGE);
        BrowserUtils.waitUntilVisible(driver, notificationMessagePage.header, Duration.ofSeconds(15));
        List<String> allMessages = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            notificationMessagePage.clickBtn.click();
            String message = notificationMessagePage.message.getText()
                    .replaceAll("[\\n×]*", "").trim();
            allMessages.add(message);
        }
        assertThat(allMessages)
                .contains(Messages.SUCCESFUL_MESSAGE.getMessage())
                .contains(Messages.UNSUCCESFUL_MESSAGE.getMessage());

    }
}
