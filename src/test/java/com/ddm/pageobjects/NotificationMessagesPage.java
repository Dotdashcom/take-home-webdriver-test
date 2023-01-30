package com.ddm.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagesPage extends WebPage {

    @FindBy(css = "div.example > p > a")
    WebElement generateNotificationsLink;

    @FindBy(css = "div#flash")
    WebElement notificationStatusArea;

    public NotificationMessagesPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public String getGeneratedNotification() {
        generateNotificationsLink.click();
        String notification = notificationStatusArea.getText();
        String[] temps= notification.split("\"");
        notification = temps[0];
        notification = notification.strip();

        return notification;
    }
}
