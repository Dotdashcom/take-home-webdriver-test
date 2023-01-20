package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class JavascriptPage {
    public WebDriver driver;
    public Helpers helpers;

    public JavascriptPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By button_alert = By.xpath("//button[@onclick=\"jsAlert()\"]");
    public By button_confirm = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    public By button_prompt = By.xpath("//button[@onclick=\"jsPrompt()\"]");

    public By result_message_p = By.id("result");
    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToJavascriptAlerts() {

        driver.navigate().to(driver.getCurrentUrl() + "javascript_alerts");
    }

    public void GoToJavascriptError() {

        driver.navigate().to(driver.getCurrentUrl() + "javascript_error");
    }

    public void ClickForJSAlert() {
        helpers.Click(button_alert);

    }

    public void AssertForJSAlert() {
        String expectedAlertMessage = "I am a JS Alert";
        String expectedResultMessage = "You successfuly clicked an alert";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
        driver.switchTo().alert().accept();

        Assert.assertEquals(expectedResultMessage, helpers.getText(result_message_p));

    }

    public void ClickForJSConfirm() {
        helpers.Click(button_confirm);

    }

    public void AssertForJSConfirmAccept() {
        String expectedAlertMessage = "I am a JS Confirm";
        String expectedResultMessage = "You clicked: Ok";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        driver.switchTo().alert().accept();

        Assert.assertEquals(helpers.getText(result_message_p), expectedResultMessage);
    }

    public void AssertForJSConfirmCancel() {
        String expectedAlertMessage = "I am a JS Confirm";
        String expectedResultMessage = "You clicked: Cancel";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(helpers.getText(result_message_p), expectedResultMessage);
    }

    public void ClickForJSPrompt() {
        helpers.Click(button_prompt);
    }

    public void AssertForJSPrompt() {
        String expectedAlertMessage = "I am a JS prompt";
        String TextInput = "This is an automated test";
        String expectedResultMessage = "You entered: ";
        String actualAlertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys(TextInput);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        driver.switchTo().alert().accept();
        Assert.assertEquals(helpers.getText(result_message_p), expectedResultMessage + TextInput);
    }

    public boolean AssertJavascriptError() {
        Set<String> errorStrings = new HashSet<>();
        errorStrings.add("SyntaxError");
        errorStrings.add("EvalError");
        errorStrings.add("ReferenceError");
        errorStrings.add("RangeError");
        errorStrings.add("TypeError");
        errorStrings.add("URIError");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            for (String errorString : errorStrings) {
                if (logEntry.getMessage().contains(errorString)) {
                    helpers.Print(logEntry.getMessage());
                    return true;
                }
            }
        }
        return false;
    }
}

