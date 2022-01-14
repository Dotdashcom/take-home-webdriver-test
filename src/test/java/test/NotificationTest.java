package test;

import methods.NotificationMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class NotificationTest extends NotificationMethod {
    private final List<String> messages = Arrays.asList("Action successful\n×", "Action unsuccesful, please try again\n×");
    @Test
    public void notificationTest() {
        startNotificationTest();
        assertTrue(messages.contains(getNotification()));

        startNotificationTest();
        assertTrue(messages.contains(getNotification()));
    }
}
