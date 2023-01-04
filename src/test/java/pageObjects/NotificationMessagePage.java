package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageComponents.NotificationAlert;

public class NotificationMessagePage extends Page {
    private static final By LOAD_NEW_MESSAGE_LINK = By.linkText("Click here");

    private NotificationAlert notificationAlert;

    public NotificationMessagePage(ChromeDriver driver) {
        super(driver);
        notificationAlert = new NotificationAlert(driver);
    }

    public NotificationMessagePage clickHere() {
        click(LOAD_NEW_MESSAGE_LINK, BasePage.TIMEOUT);
        return this;
    }

    public String getNotificationMessageText() {
        return notificationAlert.getMessage();
    }
}
