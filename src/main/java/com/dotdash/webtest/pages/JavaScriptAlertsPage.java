package com.dotdash.webtest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(29) > a")
    protected WebElement javaScriptAlertsButton;

    @FindBy(css = "#content > div > ul > li:nth-child(1) > button")
    protected WebElement jsAlertButton;

    @FindBy(css = "div.example > ul > li:nth-child(2) > button")
    protected WebElement jsConfirmButton;

    @FindBy(css = "div.example > ul > li:last-child > button")
    protected WebElement jsPromptButton;

    @FindBy(id = "result")
    protected WebElement resultMessage;

    protected Alert alert;

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToJavaScriptAlertsPage() {
        javaScriptAlertsButton.click();
    }

    public void openJsAlert() {
        jsAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openJsConfirm() {
        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openJsPrompt() {
        jsPromptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("doordash");
        alert.accept();
    }

    public String getResultText () {
        return resultMessage.getText();
    }
}
