package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessagesPage {

    WebDriver localDriver;
    public NotificationMessagesPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/notification_message']")
    @CacheLookup
    WebElement linkNotificationPage;

    @FindBy(css = "a[href='/notification_message']")
    @CacheLookup
    WebElement linkLoadMessage;

    @FindBy(xpath = "//div[contains(text(),'Action successful')]")
    @CacheLookup
    WebElement actionMessage1;

    @FindBy(xpath = "//div[contains(text(),'Action unsuccesful, please try again')]")
    @CacheLookup
    WebElement actionMessage2;

    public void clickNotificationPageLink() {
        linkNotificationPage.click();
    }

    public void clickLoadNewMessage () {
        int count = 0;
        String text = localDriver.findElement(By.id("flash")).getText();
        if (!text.contains("Action successful")) {
            linkLoadMessage.click();
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

    }
}
