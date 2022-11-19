package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/notification_message_rendered")
public class NotificationMessage extends WebPage {

    @FindBy(css = ".example a")
    private WebElement clickHereLink;

    @FindBy(id = "flash")
    private WebElement notificationMessage;

    public NotificationMessage generateNotification() {
        click(clickHereLink);
        return this;
    }

    public String getNotificationMessage() {
        return getText(notificationMessage);
    }
}
