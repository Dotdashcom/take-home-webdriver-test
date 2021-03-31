package com.webdrivertest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;

import com.webdrivertest.utils.ElementUtil;

public class JavaScriptErrorPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public JavaScriptErrorPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public boolean verifyJSError(String error) {
        boolean isExistingExpectedJSError = false;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            Level log_level = entry.getLevel();
            String logMsg = entry.getMessage();
            if (log_level.getName() == "SEVERE" && logMsg.contains(error)) {
                isExistingExpectedJSError = true;
            }
        }
		return isExistingExpectedJSError;
	}  

}
