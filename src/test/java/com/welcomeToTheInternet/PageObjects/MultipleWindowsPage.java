package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MultipleWindowsPage {

    WebDriver localDriver;
    public MultipleWindowsPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/windows']")
    @CacheLookup
    WebElement linkMultipleWindowsPage;

    @FindBy(css = "a[href='/windows/new']")
    @CacheLookup
    WebElement linkOpenNewWindow;

    public void clickMultipleWindowLink() {
        linkMultipleWindowsPage.click();
    }

    public void clickOpenNewWindowLink() {
        linkOpenNewWindow.click();
    }

    public void checkNewWindowTab() {
        String originalHandle = localDriver.getWindowHandle();
        for (String handle1: localDriver.getWindowHandles()) {
            localDriver.switchTo().window(handle1);
            if (handle1.contains("New Window")) {
                Assert.assertTrue(true);
            }
        }
        localDriver.switchTo().window(originalHandle);
    }
}
