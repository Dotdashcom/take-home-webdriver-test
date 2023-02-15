package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JavaScriptErrorPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(30) > a")
    protected WebElement JavaScriptOnloadEventErrorButton;

    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToJavaScriptOnloadEventErrorPage() {
        JavaScriptOnloadEventErrorButton.click();
    }

    public boolean isJavaScriptErrorPresent(String errorMessage) {
        LogEntries allBrowserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logsList = allBrowserLogs.getAll();
        for(LogEntry currentLogEntry: logsList) {
            if(currentLogEntry.getMessage().contains(errorMessage)) {
                return true;
            }
        }
        return false;
    }
}

