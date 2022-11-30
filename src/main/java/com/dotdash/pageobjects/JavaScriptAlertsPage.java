package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(how = How.CSS, using = "[onclick=\"jsAlert()\"]")
    private WebElement alertButton;

    @FindBy(how = How.CSS, using = "[onclick=\"jsConfirm()\"]")
    private WebElement confirmButton;

    @FindBy(how = How.CSS, using = "[onclick=\"jsPrompt()\"]")
    private WebElement promptButton;

    @FindBy(how = How.CSS, using = "[id=\"result\"]")
    private WebElement resultField;

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsPage goToJavaScriptAlertsPage() {
        driver.get(BASEURL + "/javascript_alerts");
        return this;
    }

    public JavaScriptAlertsPage clickAlertButton() {
        waitForClickabilityOf(alertButton).click();
        return this;
    }

    public JavaScriptAlertsPage clickConfirmButton() {
        waitForClickabilityOf(confirmButton).click();
        waitForAlertAvailability().accept();
        return this;
    }

    public JavaScriptAlertsPage clickPromptButton() {
        waitForClickabilityOf(promptButton).click();
        return this;
    }

    public JavaScriptAlertsPage writeToAlert(String message) {
        waitForAlertAvailability().sendKeys(message);
        waitForAlertAvailability().accept();
        return this;
    }

    public String getResultMessage() {
        return waitForVisibilityOf(resultField).getText();
    }
}
