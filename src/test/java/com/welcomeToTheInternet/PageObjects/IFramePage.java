package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IFramePage {

    WebDriver localDriver;
    public IFramePage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/frames']")
    @CacheLookup
    WebElement linkFramesPage;

    @FindBy(css = "a[href='/iframe']")
    @CacheLookup
    WebElement linkIFramePage;

    @FindBy(css = "div[aria-label='Close']")
    @CacheLookup
    WebElement closeAlert;

    @FindBy(id = "mce_0_ifr")
    @CacheLookup
    WebElement frameEditor;

    @FindBy(id = "tinymce")
    @CacheLookup
    WebElement bodyEditor;


    public void clickFramePageLink() {
        linkFramesPage.click();
    }

    public void clickIFramesPage() {
        linkIFramePage.click();
    }

    public void closeAlert() {
        closeAlert.click();
    }

    public void editText() {
        localDriver.switchTo().frame(frameEditor);
        bodyEditor.clear();
        bodyEditor.click();
        bodyEditor.sendKeys("This is a test!");
        localDriver.switchTo().defaultContent();
    }

    public void checkText() {
        localDriver.switchTo().frame(frameEditor);
        String expectedText = bodyEditor.getText();
        Assert.assertEquals("This is a test!", expectedText);
    }
}
