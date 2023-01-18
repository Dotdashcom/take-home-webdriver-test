package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptAlertsPage extends BasePage {

    // PAGE INITIALIZATION:
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By JS_ALERT = By.cssSelector("button[onclick='jsAlert()']");
    private static final By JS_CONFIRM = By.cssSelector("button[onclick='jsConfirm()']");
    private static final By JS_PROMPT = By.cssSelector("button[onclick='jsPrompt()']");
    private static final By ALERT_MSG = By.id("result");

    // WEB ELEMENTS:
    private WebElement getJsAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(JS_ALERT));
        return driver.findElement(JS_ALERT);
    }

    private WebElement getJsConfirm() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JS_CONFIRM));
        return driver.findElement(JS_CONFIRM);
    }

    public WebElement getJsPrompt() {
        wait.until(ExpectedConditions.presenceOfElementLocated(JS_PROMPT));
        return driver.findElement(JS_PROMPT);
    }

    // METHODS:
    public void clickJSAlert() {
        log.info("User clicks on the '" + getJsAlert().getText() + "' button. ");
        getJsAlert().click();
    }

    public void clickJSJsConfirm() {
        log.info("User clicks on the '" + getJsConfirm().getText() + "' button. ");
        getJsConfirm().click();
    }

    public void clickJSPrompt() {
        log.info("User clicks on the '" + getJsPrompt().getText() + "' button. ");
        getJsPrompt().click();
    }

    public boolean getAlertMessage(String txt) {
        wait.until(ExpectedConditions.presenceOfElementLocated(ALERT_MSG));
        String alertTxt = driver.findElement(ALERT_MSG).getText();
        log.info("User receives '" + txt + "' message. ");
        return alertTxt.contains(txt);
    }

    public boolean jsMessage(String txt) {
        String messageJsTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        log.info("User receives '" + messageJsTxt + "' message. ");
        return messageJsTxt.contains(txt);
    }

    public void jsPromptSendText(String txt) {
        log.info("User sends '" + txt + "' to the JS prompt. ");
        driver.switchTo().alert().sendKeys(txt);
        driver.switchTo().alert().accept();
    }

}


