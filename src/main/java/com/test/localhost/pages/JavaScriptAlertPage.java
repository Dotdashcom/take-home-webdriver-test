package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptAlertPage {

    public JavaScriptAlertPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "JavaScript Alerts")
    WebElement javaScriptAlertsButton;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(@onclick,'jsConfirm()')]")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[contains(@onclick,'jsPrompt()')]")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement message;

    public void clickJavaScriptAlerts(){
        javaScriptAlertsButton.click();
    }
    public void validateJsAlertMsg(WebDriver driver){
        jsAlertButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"I am a JS Alert");
        alert.accept();
    }
    public void validateJsConfirmMsg(WebDriver driver){
        jsConfirmButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept();
    }
    public void validateJsPrompt(WebDriver driver){
        jsPromptButton.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("doordash");
        alert.accept();
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: doordash");


    }


}
