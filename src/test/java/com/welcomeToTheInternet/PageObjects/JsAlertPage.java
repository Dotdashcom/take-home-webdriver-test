package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class JsAlertPage {

    WebDriver localDriver;
    public JsAlertPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    @CacheLookup
    WebElement linkJsAlertPage;

    @FindBy(css = "button[onclick='jsAlert()']")
    @CacheLookup
    WebElement buttonJsAlert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    @CacheLookup
    WebElement buttonJsConfirm;

    @FindBy(css = "button[onclick='jsPrompt()']")
    @CacheLookup
    WebElement buttonJsPrompt;

    public void clickJSAlertPageLink() {
        linkJsAlertPage.click();
    }

    public void clickJsAlertButton() {
        buttonJsAlert.click();
        Alert alert = localDriver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "I am a JS Alert");
        alert.accept();
    }

    public void clickJsConfirmButton() {
        buttonJsConfirm.click();
        Alert alert = localDriver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "I am a JS Confirm");
        alert.accept();
    }

    public void clickJSPromptButton() {
        buttonJsPrompt.click();
        Alert alert = localDriver.switchTo().alert();
        alert.sendKeys("TEST");
        alert.accept();
        String expectedText = localDriver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals("You entered: TEST", expectedText);
    }

    public void waitForAlert(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
