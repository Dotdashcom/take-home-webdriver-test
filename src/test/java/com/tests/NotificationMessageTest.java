package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.NotificationMessagePage;
import org.testng.annotations.Test;
import static com.assignments.constants.LinkNameConstants.NOTIFICATION_MESSAGES;
import static org.testng.Assert.assertTrue;

public final class NotificationMessageTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private NotificationMessageTest() {

    }

    @Test(description = "Validate Different Flash Message is visible on clicking Multiple time on Click Here",
            testName = "Notification Flash Message Validation")
    public void validateNotificationFlashMessage() {
        new HomePage().clickOnLink(NOTIFICATION_MESSAGES);
        assertTrue(new NotificationMessagePage().clickMultipleTimesAndValidateIfFlashMessagesAreAsExpected());
    }
}
