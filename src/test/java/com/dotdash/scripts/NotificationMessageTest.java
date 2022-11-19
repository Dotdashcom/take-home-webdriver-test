package com.dotdash.scripts;

import com.dotdash.pages.NotificationMessage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;

public class NotificationMessageTest extends BaseWebTest<NotificationMessage> {

    @Test
    public void notificationsDisplayed() {
        NotificationMessage notificationMessagePage = getInitialPage();

        List<String> validMessages = new ArrayList<>(asList("Action successful", "Action unsuccesful, please try again", "Action unsuccesful"));
        IntStream.range(0, 10).forEach(i -> {
            String message = notificationMessagePage.generateNotification().getNotificationMessage();
            boolean isMessageDisplayed = validMessages.stream().anyMatch(message::contains);
            checkThat("A valid notification message is displayed", isMessageDisplayed, is(true));
        });
    }
}
