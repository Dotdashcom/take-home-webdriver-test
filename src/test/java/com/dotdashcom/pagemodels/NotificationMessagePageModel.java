package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePageModel extends PageObject {

    public static final String PAGE_URL = "/notification_message_rendered";

    @FindBy(xpath = "//*[@id='content']/div/p/a")
    private WebElement clickHereLink;

    @FindBy(id = "flash")
    private WebElement notificationMessageDiv;

    public NotificationMessagePageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getClickHereLink() {
        return clickHereLink;
    }

    public WebElement getNotificationMessageDiv() {
        return notificationMessageDiv;
    }
}
