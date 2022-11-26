package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationsPage extends PageObjectBase {
    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    WebElement clickHereLink;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement notificationElement;

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    public NotificationsPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/notification_message_rendered");
        return this;
    }

    public NotificationsPage clickLink() {
        clickHereLink.click();
        return this;
    }

    public String getNotificationMessage() {
        Utils.explicitWait(driver, "//div[@id='flash']", 10);
        return notificationElement.getText().split("\n")[0].trim();
    }

}

