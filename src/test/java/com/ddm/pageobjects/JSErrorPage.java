package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class JSErrorPage extends WebPage {

    public JSErrorPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public boolean doesJSErrorsExist() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println("Error log entry: " + entry.getMessage());
            if (entry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
                return true;
            }
        }
        return false;
    }
}
