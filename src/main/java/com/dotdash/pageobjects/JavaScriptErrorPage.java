package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavaScriptErrorPage extends BasePage {

    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptErrorPage goToJavaScriptErrorPage() {
        driver.get(BASEURL + "/javascript_error");
        return this;
    }

    public String  getErrorLog(){
        String errorMessage = null;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            errorMessage = entry.getMessage().substring(64);
        }
        return errorMessage;
    }
}
