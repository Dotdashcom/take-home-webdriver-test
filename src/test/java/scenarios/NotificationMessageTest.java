package scenarios;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.NotificationMessagePage;

import java.util.Set;

public class NotificationMessageTest extends BaseTest {
    private static final Set<String> MESSAGES = Set.of("Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful");
    private NotificationMessagePage notificationMessagePage;

    @BeforeMethod
    public void setup() {
        notificationMessagePage = homePage.gotoNotificationMessagePage();
    }

    @Test
    public void verifyNotificationMessages() {
        SoftAssert softAssert = new SoftAssert();
        String notificationMessageText;

        for(int i = 0; i < 10; i++) {
            notificationMessageText = notificationMessagePage.clickHere()
                    .getNotificationMessageText();
            softAssert.assertTrue(MESSAGES.contains(notificationMessageText), "'" + notificationMessageText + "' doesn't match any of the possible messages!");
        }

        softAssert.assertAll();
    }
}