package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagesPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(35) > a")
    protected WebElement notificationMessagesButton;

    @FindBy(css = "div.example > p > a")
    protected WebElement clickHereButton;

    @FindBy(css = "div#flash")
    protected WebElement message;

    public NotificationMessagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToNotificationMessagesPage() {
        notificationMessagesButton.click();
    }

    public void generateNewMessage() {
        clickHereButton.click();
    }

    public String getActionMessage() {
        return message.getText();
    }
}
