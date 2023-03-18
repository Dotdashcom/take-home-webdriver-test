package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JS_ErrorPage {
    public WebDriver driver;
    public JS_ErrorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void captureJsErrorAndVerify(String error)  {
        LogEntries jsErrors=driver.manage().logs().get(LogType.BROWSER);
        Assert.assertTrue(jsErrors.getAll().get(0).toString().contains(error));
    }
}
