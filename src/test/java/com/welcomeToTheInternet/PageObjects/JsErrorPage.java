package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JsErrorPage {

    WebDriver localDriver;
    public JsErrorPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/javascript_error']")
    @CacheLookup
    WebElement linkJsErrorPage;

    public void clickJsErrorPageLink() {
        linkJsErrorPage.click();
    }

    public void checkJsError() {
        LogEntries logEntries = localDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains("Cannot read property 'xyz' of undefined")) {
                Assert.assertTrue(true);
            }
        }
    }
}
