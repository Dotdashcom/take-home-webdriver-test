package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.JsErrorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsErrorTest_16 extends BaseClass {

    @Test
    public void JsErrorTest() {
        driver.get(baseURL);
        JsErrorPage jsErrorPage = new JsErrorPage(driver);

        jsErrorPage.clickJsErrorPageLink();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains("Cannot read property 'xyz' of undefined")) {
                Assert.assertTrue(true);
            }
        }
    }
}
