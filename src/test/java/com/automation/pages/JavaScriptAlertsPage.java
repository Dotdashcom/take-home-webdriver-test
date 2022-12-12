package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    WebElement link;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement result;

    public void clickOnLink() {
        link.click();
    }

    public void verifyAlerts() {
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();

        jsConfirmButton.click();
        alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        alert.accept();

        jsPromptButton.click();
        String name = "Oscar";
        alert.sendKeys(name);
        alert.accept();
        Assert.assertTrue(result.getText().contains(name));
    }
}
