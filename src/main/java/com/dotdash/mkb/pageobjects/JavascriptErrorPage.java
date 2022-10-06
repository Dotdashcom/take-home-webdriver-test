package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;


public class JavascriptErrorPage extends BasePage {

    private List<String> browserErrors;

    public JavascriptErrorPage(WebDriver driver) {
        super(driver);
        browserErrors = new ArrayList<>();
        populateErrors();
    }

    private void populateErrors(){
        LogEntries allBrowserLogs = getDriver().manage().logs().get(LogType.BROWSER);

        List<LogEntry> logs = allBrowserLogs.getAll();
        for(LogEntry currentLog : logs){
            browserErrors.add(currentLog.getMessage());
        }
    }

    public boolean isErrorPresent(String requiredError) {
        for(String errorEntry: browserErrors) {
            if(errorEntry.contains(requiredError)) {
                return true;
            }
        }
        return false;
    }
}
