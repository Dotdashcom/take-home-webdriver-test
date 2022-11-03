package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class NotificationMessagePage {
    private static NotificationMessagePage _instance = null;
    private final By clickLink = By.cssSelector("#content a");
    private final By flashMessage = By.id("flash");

    public static NotificationMessagePage getInstance() {
        if (_instance == null) _instance = new NotificationMessagePage();
        return _instance;
    }

    public void clickLink() {
        ActionHelper.click(clickLink);
    }

    public String getFlashMessageText() {
        return ActionHelper.getText(flashMessage).replaceAll("×", "").trim();
    }

}