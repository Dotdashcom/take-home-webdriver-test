package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationMessagePage extends BasePage {

    private static final String NOTIFICATION_ENDPOINT = "notification_message_rendered";
    private static final String[] expectedMessagesWithoutTypoList = new String[]{"Action successful", "Action unsuccessful, please try again", "Action Unsuccessful"};
    private static final String[] expectedMessagesWithTypoList = new String[]{"Action successful", "Action unsuccesful, please try again", "Action Unsuccessful"};

    @FindBy(css = ".example a")
    private WebElement clickHereLink;

    @FindBy(css = "#flash-messages #flash")
    private WebElement notificationMessage;

    @FindBy(css = "#flash-messages #flash a")
    private WebElement closeMessageLink;

    @FindBy(css = "#flash-messages #flash")
    private List<WebElement> notificationMessageList;

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public NotificationMessagePage getNotificationMessagePage() {
        getDriver(NOTIFICATION_ENDPOINT);

        return this;
    }

    public NotificationMessagePage clickHereLink() {
        clickHereLink.click();
        getWait(2).until(ExpectedConditions.visibilityOf(notificationMessage));

        return this;
    }

    public String getNotificationMessageText() {

        return notificationMessage.getText().replace(closeMessageLink.getText(), "").trim();
    }

    public boolean isNotificationMessageDisplayed() {

        return notificationMessageList.size() > 0;
    }

    public NotificationMessagePage clickMultipleTimes(int numberOfTimes) {
        for(int i = 0; i < numberOfTimes; i++) {
            clickHereLink.click();
        }

        return this;
    }

    public boolean isDisplayedMessageInTheExpectedMessagesWithoutTypoList() {

        return Arrays.stream(expectedMessagesWithoutTypoList).anyMatch(element->element.equals(getNotificationMessageText()));
    }

    public boolean isDisplayedMessageInTheExpectedMessagesWithTypoList() {

        return Arrays.stream(expectedMessagesWithTypoList).anyMatch(element->element.equals(getNotificationMessageText()));
    }

    public Map<String, Integer> getExpectedMessagesWithTypoCount(int numberOfLinkClicks) {
        Map<String, Integer> expectedMessagesWithTypoCounter = new HashMap<>();
        for (String string : expectedMessagesWithTypoList) {
            expectedMessagesWithTypoCounter.put(string, 0);
        }

        for(int i = 0; i < numberOfLinkClicks; i++) {
            String notificationMessageText = clickHereLink()
                    .getNotificationMessageText();
            if(expectedMessagesWithTypoCounter.containsKey(notificationMessageText)) {
                expectedMessagesWithTypoCounter.put(notificationMessageText,
                        expectedMessagesWithTypoCounter.get(notificationMessageText) + 1);
            } else {
                expectedMessagesWithTypoCounter.put(notificationMessageText, 1);
            }
        }

        return expectedMessagesWithTypoCounter;
    }

    public Map<String, Integer> getExpectedMessagesWithoutTypoCount(int numberOfLinkClicks) {
        Map<String, Integer> expectedMessagesWithoutTypoCounter = new HashMap<>();
        for (String string : expectedMessagesWithoutTypoList) {
            expectedMessagesWithoutTypoCounter.put(string, 0);
        }

        for(int i = 0; i < numberOfLinkClicks; i++) {
            String notificationMessageText = clickHereLink()
                    .getNotificationMessageText();
            if(expectedMessagesWithoutTypoCounter.containsKey(notificationMessageText)) {
                expectedMessagesWithoutTypoCounter.put(notificationMessageText,
                        expectedMessagesWithoutTypoCounter.get(notificationMessageText) + 1);
            } else {
                expectedMessagesWithoutTypoCounter.put(notificationMessageText, 1);
            }
        }

        return expectedMessagesWithoutTypoCounter;
    }
}