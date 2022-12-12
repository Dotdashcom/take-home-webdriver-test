package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NotificationMessagePage extends BasePage {

    @FindBy(xpath = "//a[@href='/notification_message']")
    WebElement link;

    @FindBy(xpath = "//p/a[@href='/notification_message']")
    WebElement clickButton;

    @FindBy(id = "flash")
    WebElement text;

    public void clickOnLink() {
        link.click();
    }

    public void verifyMessage() {
        Actions actions = new Actions(driver);
        actions.doubleClick(clickButton).perform();
        Assert.assertTrue(text.getText().contains("Action unsuccesful, please try again") ||
                text.getText().contains("Action succesful"));
    }
}
