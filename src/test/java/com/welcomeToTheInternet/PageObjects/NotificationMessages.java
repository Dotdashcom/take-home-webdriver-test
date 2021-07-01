package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessages {

    WebDriver localDriver;
    public NotificationMessages(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/notification_message']")
    @CacheLookup
    WebElement linkNotificationMessage;

    @FindBy(linkText = "Click here")
    @CacheLookup
    WebElement loadMessage;


    public void clickNotificationMessageLink() {
        linkNotificationMessage.click();
    }

    public void clickLoadMessage() {
        loadMessage.click();
    }

    public String checkMessage() {
        WebElement flash = localDriver.findElement(By.id("flash"));
        return flash.getText();
    }

}
