package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NotificationMessagePage extends BasePage {

    @FindBy(how = How.CSS, using = "[href=\"/notification_message\"]")
    private WebElement displayButton;

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public NotificationMessagePage goToNotificationMessagePage() {
        driver.get(BASEURL + "/notification_message_rendered");
        return this;
    }

    public NotificationMessagePage displayNotification(){
        waitForClickabilityOf(displayButton).click();
        return this;
    }

    @Override
    public String getAlertMessage(){
        return waitForVisibilityOf(alertElement).getText().replaceAll("\\n.", "");
    }

}
