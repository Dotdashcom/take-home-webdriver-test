package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private By jsAlertButton = By.xpath("//button[contains(text(),'JS Alert')]");
    private By jsConfirmButton = By.xpath("//button[contains(text(),'JS Confirm')]");
    private By jsPromptButton = By.xpath("//button[contains(text(),'JS Prompt')]");
    private By resultMessage = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("javascriptalerts"));
    }

    public void clickJSAlertButton() {
        driver.findElement(jsAlertButton).click();
    }

    public void clickJSConfirmButton() {
        driver.findElement(jsConfirmButton).click();
    }

    public void clickJSPromptButton(String inputText) {
        driver.findElement(jsPromptButton).click();
    }

    public String getResultMessage() {
        return driver.findElement(resultMessage).getText();
    }
}
