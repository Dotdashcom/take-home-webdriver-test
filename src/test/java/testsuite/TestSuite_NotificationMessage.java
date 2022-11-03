package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.NotificationMessagePage;

import java.util.Arrays;
import java.util.List;

public class TestSuite_NotificationMessage extends BaseTestClass {

    @Test
    public void TC_NotificationMessage_001_Verify_AlertMessage() {
        ActionHelper.openUrl(Constants.NOTIFICATION_PAGE_URL);
        NotificationMessagePage notificationMessagePage = NotificationMessagePage.getInstance();
        List<String> expectedMessages = Arrays.asList("Action successful",
                "Action unsuccesful, please try again", "Action Unsuccessful");
        notificationMessagePage.clickLink();
        System.out.println(notificationMessagePage.getFlashMessageText());
        Assert.assertTrue(expectedMessages.contains(notificationMessagePage.getFlashMessageText()),
                "Validate expected Error Message");
    }
}
