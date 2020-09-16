package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class JavaScriptAlertsPage extends PageBase {

    /*
    Test Clicks on JS Alert Button.
    Test asserts alert message.
    Test clicks on JS confirm Button and clicks ok on alert.
    Test asserts the alert message.
    Test clicks on JS Prompt Button and types a message on Prompt.
    Test asserts that the alert message contains the typed message.
     */
    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    protected WebElement jsAlertButton;

    @FindBy(xpath = "//*[text()='Click for JS Confirm']")
    protected WebElement jsConfirmButton;

    @FindBy(xpath = "//*[text()='Click for JS Prompt']")
    protected WebElement jsPromptButton;

    @FindBy(xpath = "//*[@id='result']")
    protected WebElement resultMessage;

    public void clickAlert(){
        jsAlertButton.click();
        String expected = "I am a JS Alert";
        String alertMessage =driver.switchTo().alert().getText();
        Assert.assertEquals(expected,alertMessage);
        driver.switchTo().alert().accept();
    }
    public void clickToConfirm(){
        jsConfirmButton.click();
        String expected = "I am a JS Confirm";
        String alertMessage =driver.switchTo().alert().getText();
        Assert.assertEquals(expected,alertMessage);
        driver.switchTo().alert().accept();
    }
    public void clickPrompt(){
        jsPromptButton.click();
        driver.switchTo().alert().sendKeys("Hallo World");
        driver.switchTo().alert().accept();
        BrowserUtils.waitForVisibility(resultMessage,5);
        Assert.assertTrue(resultMessage.getText().contains("Hallo World"));


    }
}
