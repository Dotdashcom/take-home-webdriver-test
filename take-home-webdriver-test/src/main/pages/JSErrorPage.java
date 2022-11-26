package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class JSErrorPage extends PageObjectBase {
    public JSErrorPage(WebDriver driver) {
        super(driver);
    }

    public JSErrorPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/javascript_error");
        return this;
    }

    public List<String> findErrors() {
        List<String> errorsList = new ArrayList<>();
        String message;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            message = entry.getMessage().split(": ")[1];
            errorsList.add(message);
        }
        return errorsList;
    }
}
