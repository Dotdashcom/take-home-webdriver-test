package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NotificationMessagePage extends BasePage {
    public NotificationMessagePage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//a[text()='Click here']")
    private WebElement clickHereBtn;

    @FindBy (xpath = "//div[@id='flash']")
    private WebElement notificationMsg;

    public void verifyNotificationMessage(){
        Set<String> notifications = new HashSet<>();

        while (notifications.size() < 2) {
            btnClick(clickHereBtn);
            notifications.add(notificationMsg.getText().strip().replace("×","").replaceAll("[\n\r]", ""));
        }

        softAssert.assertTrue(notifications.contains("Action successful"), "Action Successful has not shown");
        softAssert.assertTrue(notifications.contains("Action unsuccesful, please try again"), "Action unsuccesful, please try again has not shown");
    }
}
