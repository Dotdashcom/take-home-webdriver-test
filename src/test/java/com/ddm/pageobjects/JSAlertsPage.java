package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertsPage extends WebPage {

    @FindBy(css = "div.example > ul > li:first-child > button")
    protected WebElement jsAlertButton;

    @FindBy(css = "div.example > ul > li:nth-child(2) > button")
    protected WebElement jsConfirmButton;

    @FindBy(css = "div.example > ul > li:last-child > button")
    protected WebElement jsPromptButton;

    @FindBy(css = "#result")
    protected WebElement resultAreaText;


    public JSAlertsPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public String clickJSAlertAndAccept() {
        jsAlertButton.click();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }

    public String clickJSConfirmAndClickOK() {
        jsConfirmButton.click();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }

    public void clickJSPromptAndClickOK(String text) {
        jsPromptButton.click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getResultAreaText() {
        return resultAreaText.getText();
    }
}