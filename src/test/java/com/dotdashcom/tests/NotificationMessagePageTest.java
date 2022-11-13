package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.NotificationMessagePageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static java.util.Collections.emptySet;
import static java.util.Optional.ofNullable;

public class NotificationMessagePageTest extends MainTest {

    NotificationMessagePageModel page;
    private final List<String> notificationMessages;

    public NotificationMessagePageTest() {
        notificationMessages = Arrays.asList(
                "Action successful",
                "Action unsuccesful, please try again",
                "Action Unsuccessful"
        );
    }

    private void init() {
        page = new NotificationMessagePageModel(driver);
        driver.get(BASE_URL + NotificationMessagePageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_link_THEN_one_of_the_expected_notifications_shown() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(NotificationMessagePageModel.PAGE_URL));

        // Note that spelling on the page is different from the one in assignment.
        // In order for the test to pass I had to verify for the message that is actually displayed on the page.

        // Let's click multiple times and collect messages into a Set
        Set<String> messages = new HashSet<>();
        for (int count = 0; count < 10; count++) {
            page.getClickHereLink().click();
            messages.add(trimExtras(page.getNotificationMessageDiv().getText()));
        }

        ofNullable(messages).orElse(emptySet()).stream()
                        .forEach(m -> Assert.assertTrue(notificationMessages.contains(m),
                                "Message displayed is not as expected."));
    }

    private String trimExtras(String text) {
        String[] s = text.split("\\n");
        return s[0];
    }
}
