package com.framework.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSAlertsPage extends PageObjectBase {

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    WebElement jsPromptButton;

    @FindBy(xpath = "//p[@id='result']")
    WebElement results;

    public JSAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JSAlertsPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/javascript_alerts");
        return this;
    }

    public JSAlertsPage clickJSAlertButton() {
        jsAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    public JSAlertsPage clickJSConfirmButton() {
        jsConfirmButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public JSAlertsPage clickJSPromptButton(String message) {
        jsPromptButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(message);
        alert.accept();
        return this;
    }

    public String getResults() {
        return results.getText();
    }
}
