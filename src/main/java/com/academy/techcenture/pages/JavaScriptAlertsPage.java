package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import static com.academy.techcenture.configReader.ConfigReader.*;

public class JavaScriptAlertsPage extends BasePage {
    public JavaScriptAlertsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertBtn;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmBtn;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptBtn;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement resultMsg;

    public void verifyJavaScriptAlerts() {
        verifyButtons();
        btnClick(jsAlertBtn);
        verifyAndAccept("JS Alert", "You successfuly clicked an alert");
        btnClick(jsConfirmBtn);
        verifyAndAccept("JS Confirm", "You clicked: Ok");
        btnClick(jsPromptBtn);
        softAssert.assertEquals(driver.switchTo().alert().getText().trim(),"I am a JS prompt");
        driver.switchTo().alert().sendKeys(getProperty("randomMsg"));
        driver.switchTo().alert().accept();
        softAssert.assertEquals(resultMsg.getText().trim(),"You entered: " + getProperty("randomMsg"));
        }

    private void verifyButtons(){
        softAssert.assertTrue(jsAlertBtn.isDisplayed(),"JS Alert Button is not displayed");
        softAssert.assertTrue(jsAlertBtn.isEnabled(),"JS Alert Button is not enabled");
        softAssert.assertTrue(jsConfirmBtn.isDisplayed(),"JS Confirm Button is not displayed");
        softAssert.assertTrue(jsConfirmBtn.isEnabled(),"JS Confirm Button is not enabled");
        softAssert.assertTrue(jsPromptBtn.isDisplayed(),"JS Prompt Button is not displayed");
        softAssert.assertTrue(jsPromptBtn.isEnabled(),"JS Prompt Button is not enabled");
        softAssert.assertTrue(resultMsg.getText().isEmpty(),"Result message has a text, before any implementation");
    }

    private void verifyAndAccept(String button, String expectedMessage){
        softAssert.assertEquals(driver.switchTo().alert().getText().trim(),"I am a " + button, button + " message is not match");
        driver.switchTo().alert().accept();
        softAssert.assertEquals(resultMsg.getText().trim(),expectedMessage, "Result message is not match while "+ button + " message is accepted");
    }

}
