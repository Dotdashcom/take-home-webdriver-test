package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertsPage extends Page {
    private static final String JS_BUTTON = "//button[contains(text(), '%s')]";
    private static final By RESULT = By.id("result");

    private Alert jsAlert;

    public JavaScriptAlertsPage(ChromeDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsPage clickJSAlertButton() {
        click(By.xpath(String.format(JS_BUTTON, "Alert")), BasePage.TIMEOUT);
        initAlert();
        return this;
    }

    public JavaScriptAlertsPage clickJSConfirmButton() {
        click(By.xpath(String.format(JS_BUTTON, "Confirm")), BasePage.TIMEOUT);
        initAlert();
        return this;
    }

    public JavaScriptAlertsPage clickJSPromptButton() {
        click(By.xpath(String.format(JS_BUTTON, "Prompt")), BasePage.TIMEOUT);
        initAlert();
        return this;
    }

    private void initAlert() {
        jsAlert = getAlert(BasePage.ACTION_TIMEOUT);
    }

    public JavaScriptAlertsPage enterPromptMessage(String message) {
        jsAlert.sendKeys(message);
        return this;
    }

    public JavaScriptAlertsPage acceptAlert() {
        jsAlert.accept();
        return this;
    }

    public String getJSAlertMessageText() {
        return jsAlert.getText();
    }

    public boolean getResultText(String text) {
        return textToBe(RESULT, text, BasePage.ACTION_TIMEOUT);
    }
}
