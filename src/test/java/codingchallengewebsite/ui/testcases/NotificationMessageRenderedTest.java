package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.NotificationMessageRenderedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageRenderedTest extends UITests {

    public NotificationMessageRenderedTest() {
    }

    @Test(description="Validates messages shown inside the flash box")
    public void validateFlashMessages() {
        NotificationMessageRenderedPage notificationMessageRenderedPage = new NotificationMessageRenderedPage(this.driver, this);
        Assert.assertTrue(notificationMessageRenderedPage.isPageOpen(), "Page not open");

        Assert.assertTrue(notificationMessageRenderedPage.validateFlashMessages(), "Messages couldn't be validated");
    }
}
