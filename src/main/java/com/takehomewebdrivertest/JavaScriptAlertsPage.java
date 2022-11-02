package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    ConfigFileReader configFileReader;

    private final String URL = "/javascript_alerts";

    private final By pageTitle = By.cssSelector("h3");
    private final By jsAlert = By.xpath("//ul/li/button[@onclick=\"jsAlert()\"]");
    private final By jsConfirm = By.xpath("//ul/li/button[@onclick=\"jsConfirm()\"]");
    private final By jsPrompt = By.xpath("//ul/li/button[@onclick=\"jsPrompt()\"]");
    private final By resultText = By.id("result");
    private final String promptText = "Testing";

    public void navigateToJavaScriptAlertsPage() throws Exception {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/javascript_alerts");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("JavaScript Alerts");
    }


    public void clickOnJSAlert() throws Exception {
        click(jsAlert);
    }

    public void validateAlertPresence(String alert) {
        String alertText = handleAlert("Text", "");
        assertThat(alertText).contains(alert);
    }

    public void clickOkOnAlert() {
        handleAlert("Accept","");
    }

    public void verifyResult(String result) {
        String resultMsg = driver.findElement(resultText).getText();
        assertThat(resultMsg).contains(result);
    }

    public void clickOnJSConfirm() throws Exception {
        click(jsConfirm);
    }

    public void clickOnAlertBtn(String button) {
        switch (button) {
            case "Ok":
                handleAlert("Accept", "");
                break;
            case "Cancel":
                handleAlert("Dismiss", "");
                break;
        }
    }

    public void clickOnJSPrompt() throws Exception {
        click(jsPrompt);
    }

    public void writeTextOnAlert(String text) {
        handleAlert("Keys", text);
    }
}
