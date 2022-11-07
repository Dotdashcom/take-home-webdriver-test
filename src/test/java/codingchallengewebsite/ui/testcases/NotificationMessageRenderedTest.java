package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.NotificationMessageRenderedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageRenderedTest extends UITest {

    public NotificationMessageRenderedTest() { }

    @Test(description="Validates messages shown inside the flash box")
    public void validateFlashMessages() {
        NotificationMessageRenderedPage notificationMessageRenderedPage = new NotificationMessageRenderedPage(this);

        // Validate page loaded
        Assert.assertTrue(notificationMessageRenderedPage.isPageOpen(), "Page not open");

        // Validate expected messages displayed
        Assert.assertTrue(notificationMessageRenderedPage.validateFlashMessages(), "Messages couldn't be validated");
    }
}