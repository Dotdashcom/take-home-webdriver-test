package com.dotdash.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaScriptAlertPage extends BasePageObject {

    private final int MAX_WAIT_TIME = 10;
    private By js_alert = By.cssSelector("[onclick='jsAlert()']");
    private By js_confirm = By.cssSelector("[onclick='jsConfirm()']");
    private By js_prompt = By.cssSelector("[onclick='jsPrompt()']");
    private By text_result = By.id("result");

    private String actual_js_alert_content = null;
    private String actual_js_confirm_content = null;
    private String actual_js_prompt_content = null;
    private String input_js_prompt_text = null;

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
        open_page("javascript_alerts");
    }

    // --- JS ALERT SCOPE ---
    public JavaScriptAlertPage click_on_js_alert_btn() {
        driver.findElement(js_alert).click();
        return this;
    }

    public JavaScriptAlertPage accept_js_alert() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        actual_js_alert_content = alert.getText();
        alert.accept();
        return this;
    }

    public void verify_text_after_accept_js_alert() {
        String expected_alert_content = "I am a JS Alert";
        Assert.assertEquals(actual_js_alert_content, expected_alert_content, "[ERR] Js Alert content is incorrect!");

        String expected_result_text = "You successfuly clicked an alert";
        String actual_result_text = driver.findElement(text_result).getText();
        Assert.assertEquals(actual_result_text, expected_result_text, "[ERR] Result text in incorrect");
    }

    // --- JS CONFIRM SCOPE ---
    public JavaScriptAlertPage click_on_js_confirm_btn() {
        driver.findElement(js_confirm).click();
        return this;
    }

    public JavaScriptAlertPage accept_js_confirm() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        click_js_confirm_with_action(true, alert);
        return this;
    }

    public JavaScriptAlertPage dismiss_js_confirm() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        click_js_confirm_with_action(false, alert);
        return this;
    }

    private void click_js_confirm_with_action(boolean isOK, Alert alert) {
        actual_js_confirm_content = alert.getText();
        if (isOK) alert.accept();
        else alert.dismiss();
    }

    public void verify_text_after_accept_js_confirm() {
        verify_text_after_dismiss_js_confirm_with_action(true);
    }

    public void verify_text_after_cancel_js_confirm() {
        verify_text_after_dismiss_js_confirm_with_action(false);
    }

    private void verify_text_after_dismiss_js_confirm_with_action(boolean isOK) {
        String expected_accept_js_confirm_text_result = "You clicked: Ok";
        String expected_dismiss_js_confirm_text_result = "You clicked: Cancel";
        String actual_result_text = driver.findElement(text_result).getText();
        if (isOK) Assert.assertEquals(expected_accept_js_confirm_text_result, actual_result_text);
        else Assert.assertEquals(expected_dismiss_js_confirm_text_result, actual_result_text);
    }

    // --- JS PROMPT SCOPE ---
    public JavaScriptAlertPage click_on_js_prompt_btn() {
        driver.findElement(js_prompt).click();
        return this;
    }

    public JavaScriptAlertPage accept_js_prompt() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        actual_js_prompt_content = alert.getText();
        alert.accept();
        return this;
    }

    public JavaScriptAlertPage accept_js_prompt(String with_text) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        actual_js_prompt_content = alert.getText();
        input_js_prompt_text = with_text;
        alert.sendKeys(with_text);
        alert.accept();
        return this;
    }

    public JavaScriptAlertPage dismiss_js_prompt() {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        actual_js_prompt_content = alert.getText();
        alert.dismiss();
        return this;
    }

    public void verify_text_result_after_accept_with_text_js_prompt() {
        Assert.assertEquals(actual_js_prompt_content, "I am a JS prompt", "[ERR] Wrong JS Prompt content!");
        String actual_text_result = driver.findElement(text_result).getText();
        Assert.assertEquals(actual_text_result, "You entered:", "[ERR] JS Prompt, text result incorrect!");
    }

    public void verify_text_result_after_accept_with_text_js_prompt(String with_text) {
        Assert.assertEquals(actual_js_prompt_content, "I am a JS prompt", "[ERR] Wrong JS Prompt content!");
        String actual_text_result = driver.findElement(text_result).getText();
        Assert.assertEquals(actual_text_result, "You entered: " + with_text, "[ERR] JS Prompt, text result incorrect!");
    }

    public void verify_text_result_after_dismiss_js_prompt() {
        Assert.assertEquals(actual_js_prompt_content, "I am a JS prompt", "[ERR] Wrong JS Prompt content!");
        String actual_text_result = driver.findElement(text_result).getText();
        Assert.assertEquals(actual_text_result, "You entered: null", "[ERR] JS Prompt, text result incorrect!");
    }
}
