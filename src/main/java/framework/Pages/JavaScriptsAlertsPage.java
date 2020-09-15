package framework.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptsAlertsPage {

    WebDriver driver;

    public JavaScriptsAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='content']/div/ul/li[1]/button")
    WebElement JSAlert;

    @FindBy (xpath = "//*[@id='content']/div/ul/li[2]/button")
    WebElement JSConfirm;

    @FindBy (xpath = "//*[@id='content']/div/ul/li[3]/button")
    WebElement JSPrompt;

    @FindBy (id = "result")
    WebElement result;

    public void dismissJSAlert(){
        JSAlert.click();
        Alert jsAlert = driver.switchTo().alert();
        String alertText = jsAlert.getText();
        Assert.assertEquals("I am a JS Alert", alertText);
        jsAlert.dismiss();
    }

    public void confirmJSConfirm(){
        JSConfirm.click();
        Alert jsConfirmAlert = driver.switchTo().alert();
        String alertText = jsConfirmAlert.getText();
        Assert.assertEquals("I am a JS Confirm", alertText);
        jsConfirmAlert.accept();
        Assert.assertEquals("You clicked: Ok", result.getText());
    }

    public void inputTextToPrompt(String text){
        JSPrompt.click();
        Alert jsPromptAlert = driver.switchTo().alert();
        String alertText = jsPromptAlert.getText();
        Assert.assertEquals("I am a JS prompt", alertText);
        jsPromptAlert.sendKeys(text);
        jsPromptAlert.accept();
        Assert.assertEquals(("You entered: " + text), result.getText());
    }
}
