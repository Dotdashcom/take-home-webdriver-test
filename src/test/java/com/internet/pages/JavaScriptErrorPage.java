package com.internet.pages;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class JavaScriptErrorPage extends BasePage{


    public boolean ifJSErrorExists(String message){
        LogEntries full = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> all = full.getAll();
        boolean flag=false;
        for (LogEntry logEntry : all) {
            flag = logEntry.getMessage().contains(message);

        }
        return flag;
    }



}
