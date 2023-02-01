package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class JavaScriptErrorPage extends BasePage{
    public JavaScriptErrorPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(tagName = "p")
    private WebElement errorMsg;

    public void verifyJavascriptErrors(){
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log:logs) {
            String logMessage = log.getMessage();
            if (logMessage.contains("Cannot read properties of undefined (reading 'xyz')")){
                softAssert.assertTrue(logMessage.contains("Cannot read properties of undefined (reading 'xyz')"));
                break;
            }
        }
    }

}
