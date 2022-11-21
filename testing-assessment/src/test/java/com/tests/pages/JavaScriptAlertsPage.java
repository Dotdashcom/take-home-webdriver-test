package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "(//button)[1]")
    private WebElement jsAlertButtonInput;

    @FindBy(xpath = "(//button)[2]")
    private WebElement jsConfirmButtonInput;

    @FindBy(xpath = "(//button)[3]")
    private WebElement jsPromptButtonInput;

    @FindBy(id = "result")
    private WebElement resultInput;


    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/javascript_alerts ");
    }


    @Test
    public void clickOnJSAlertButton() {
        waitForVisibilityOf(jsAlertButtonInput);
        jsAlertButtonInput.click();
        String jsAlertText = DriverTest.getDriver().switchTo().alert().getText();
        Assert.assertTrue(jsAlertText.contains("I am a JS Alert"));
        System.out.println("-> JS Alert text message is: " + jsAlertText);
        DriverTest.getDriver().switchTo().alert().accept();
    }

    @Test
    public void clickOnJSConfirmButton() {
        waitForVisibilityOf(jsConfirmButtonInput);
        jsConfirmButtonInput.click();
        String jsConfirmText = DriverTest.getDriver().switchTo().alert().getText();
        Assert.assertTrue(jsConfirmText.contains("I am a JS Confirm"));
        System.out.println("-> JS Confirm text message is: " + jsConfirmText);
        DriverTest.getDriver().switchTo().alert().accept();
    }

    @Test
    public void clickOnJSPromptButton() {
        waitForVisibilityOf(jsPromptButtonInput);
        jsPromptButtonInput.click();
        DriverTest.getDriver().switchTo().alert().sendKeys("Hello World!");
        DriverTest.getDriver().switchTo().alert().accept();
        String enteredMessage = resultInput.getText();
        Assert.assertTrue(enteredMessage.contains("Hello"));
        System.out.println("-> JS Prompt entered text message is: " + enteredMessage);
    }

    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}
