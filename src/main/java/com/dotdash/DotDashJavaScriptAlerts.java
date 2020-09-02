package com.dotdash;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashJavaScriptAlerts extends BaseAPI {

    @FindBy(how = How.XPATH, using = jsAlertXp)
    public WebElement jsAlert;
    @FindBy(how = How.XPATH, using = jsAlertConfirmXp)
    public WebElement jsAlertConfirm;
    @FindBy(how = How.XPATH, using = jsAlertPromptXp)
    public WebElement jsAlertPrompt;
    @FindBy(how = How.CSS, using = promptResultCss)
    public WebElement promptResult;

    public static void clickAlert() {
        initPage();
        click(jsAlerts.jsAlert);
    }

    public static void clickConfirmAlert() {
        initPage();
        click(jsAlerts.jsAlertConfirm);
    }

    public static void clickPromptAlert() {
        initPage();
        click(jsAlerts.jsAlertPrompt);
    }

    public static void enterPrompt(String prompt) {
        initPage();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(prompt);
    }

    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void assertPromptMessage(String expectedPrompt) {
        initPage();
        String expectedPromptResult = "You entered: " + expectedPrompt;
        String actualPromptResult = jsAlerts.promptResult.getText();
        System.out.println("Expected Prompt Result " + expectedPromptResult);
        System.out.println("Actual Prompt Result " + actualPromptResult);
        Assert.assertEquals(actualPromptResult, expectedPromptResult);
    }

    public static void assertAlertMessage(String expectedMessage) {
        initPage();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        System.out.println("Actual Alert Message: " + alertMessage);
        System.out.println("Expected Alert Message: " + expectedMessage);
        Assert.assertEquals(alertMessage, expectedMessage);
    }

    static DotDashJavaScriptAlerts jsAlerts;

    public static void initPage() {
        jsAlerts = PageFactory.initElements(driver, DotDashJavaScriptAlerts.class);
    }

    public static void navigateToJsAlertsPage() {
        driver.get(baseURL + "javascript_alerts");
    }


}
