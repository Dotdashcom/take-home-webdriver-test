package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class JavaScriptErrorPage extends BasePage {

    // PAGE INITIALIZATION:
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    // METHODS:
    public boolean checkForErrorInLogs(String error) {
        LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> listOfLogs = jsErrors.getAll();
        for (LogEntry logEntry : listOfLogs) {
            System.out.println("JS Errors are " + logEntry);
            if (logEntry.getMessage().contains(error)) {
                return true;
            }
        }
        return false;
    }
}


