package com.homewebdriver.webpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofMillis;

public class JavaScriptAlertsPage {
    WebDriver driver;

    private static String JAVASCRIPT_ALERTS_URL="http://localhost:7080/javascript_alerts";

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    public WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    public WebElement jsConfirmButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    public WebElement jsPromptButton;




    public JavaScriptAlertsPage(WebDriver driver){
        this.driver=driver;
        driver.get(JAVASCRIPT_ALERTS_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void verifyJsAlert() {
        jsAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver,ofMillis(10000));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        if(text.equals("I am a JS Alert")) {
            alert.accept();
        }
    }
    public void verifyJsConfirm() {
        jsConfirmButton.click();
        WebDriverWait wait = new WebDriverWait(driver,ofMillis(10000));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        String text = alert.getText();
        if(text.equals("I am a JS Confirm")) {
            alert.accept();
            jsConfirmButton.click();
            alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }
    public void verifyJsPrompt() {
        jsPromptButton.click();
        WebDriverWait wait = new WebDriverWait(driver,ofMillis(10000));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        if(text.equals("I am a JS prompt")) {
            alert.sendKeys("Selenium");
            alert.accept();
        }
    }
}
