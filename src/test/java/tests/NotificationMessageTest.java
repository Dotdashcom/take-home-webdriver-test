package tests;

import model.NotificationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

import java.util.*;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void testIsMessageInTheExpectedMessageList_ListWithoutTypo_testToFail() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage();
        int numberOfLinkClicks = 25;
        boolean isMessageInTheExpectedList = false;

        for(int i = 0; i < numberOfLinkClicks; i++) {
            isMessageInTheExpectedList = notificationMessagePage
                    .clickHereLink()
                    .isDisplayedMessageInTheExpectedMessagesWithoutTypoList();
            if(!isMessageInTheExpectedList) {
                BaseUtils.logf("The message \"%s\" is not in the Expected Messages List",
                        notificationMessagePage.getNotificationMessageText());
                break;
            }
        }

        Assert.assertTrue(isMessageInTheExpectedList);
    }

    @Test
    public void testIsMessageInTheExpectedMessageList_ListWithTypo() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage();
        int numberOfLinkClicks = 25;
        boolean isMessageInTheExpectedList = false;

        for(int i = 0; i < numberOfLinkClicks; i++) {
            isMessageInTheExpectedList = notificationMessagePage
                    .clickHereLink()
                    .isDisplayedMessageInTheExpectedMessagesWithTypoList();
            if(!isMessageInTheExpectedList) {
                BaseUtils.logf("The message \"%s\" is not in the Expected Messages With Typo List",
                        notificationMessagePage.getNotificationMessageText());
                break;
            }
        }

        Assert.assertTrue(isMessageInTheExpectedList);
    }

    @Test
    public void testAreAllExpectedMessagesDisplayed_ListWithTypo_testToFail() {
        Set<String> areThereUnusedMessages = new HashSet<>();

        Map <String, Integer> expectedMessagesWithTypoCount  = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage()
                .getExpectedMessagesWithTypoCount(25);

        for(Map.Entry<String, Integer> entry : expectedMessagesWithTypoCount.entrySet()) {
            if(entry.getValue() == 0) {
                areThereUnusedMessages.add(entry.getKey());
            }
        }

        for(Map.Entry<String, Integer> entry : expectedMessagesWithTypoCount.entrySet()) {
            if(entry.getValue() == 0) {
                areThereUnusedMessages.add(entry.getKey());
            }
        }

        Assert.assertTrue(areThereUnusedMessages.size() == 0,
                String.format("Message(s) \"%s\" never used contrary to the specifications.", areThereUnusedMessages));
    }

    @Test
    public void testAreAllExpectedMessagesDisplayed_ListWithoutTypo_testToFail() {
        Set<String> areThereUnusedMessages = new HashSet<>();

        Map <String, Integer> expectedMessagesWithoutTypoCount  = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage()
                .getExpectedMessagesWithoutTypoCount(25);

        for(Map.Entry<String, Integer> entry : expectedMessagesWithoutTypoCount.entrySet()) {
            if(entry.getValue() == 0) {
                areThereUnusedMessages.add(entry.getKey());
            }
        }

        Assert.assertTrue(areThereUnusedMessages.size() == 0,
                String.format("Message(s) \"%s\" never used contrary to the specifications.", areThereUnusedMessages));
    }

    @Test
    public void testNotificationMessage() {
        boolean isNotificationMessageDisplayed = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage()
                .clickHereLink()
                .isNotificationMessageDisplayed();

        Assert.assertTrue(isNotificationMessageDisplayed);
    }

    @Test
    public void testNotificationMessageText() {
        String expectedResult = "Action";

        String actualResult = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage()
                .clickHereLink()
                .getNotificationMessageText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void testNotificationMessageText_LuckyWin() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(getDriver())
                .getNotificationMessagePage();
        Map<String, Integer> notificationMessagesStatistics = new HashMap<>();
        int numberOfIterations = 25;

        for(int i = 0; i < numberOfIterations; i++) {
            String notificationMessageText = notificationMessagePage
                    .clickHereLink()
                    .getNotificationMessageText();
            if(notificationMessagesStatistics.containsKey(notificationMessageText)) {
                notificationMessagesStatistics.put(notificationMessageText,
                        notificationMessagesStatistics.get(notificationMessageText) + 1);
            } else {
                notificationMessagesStatistics.put(notificationMessageText, 1);
            }
            getDriver().navigate().refresh();
         }

        notificationMessagesStatistics
                .forEach((key, value)-> BaseUtils.logf(
                        "\"%s\" was loaded %s times, which is %d%% of iterations",
                        key, value, Math.floorDiv((int) Math.multiplyExact(100,value), numberOfIterations)));
        Assert.assertTrue(!notificationMessagesStatistics.containsValue(numberOfIterations),
                "If this test fails it is a lucky day");
    }
}