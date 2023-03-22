package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.test.util.Config;

public class JavaScriptErrorPage {

    private WebDriver driver;

    private By errorMessage = By.tagName("body");

    public JavaScriptErrorPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("javascripterror"));
    }

    public boolean isPageLoaded() {
        return driver.getTitle().equals("Page with JavaScript errors on load");
    }

    public boolean isJavaScriptErrorDisplayed() {
        return driver.findElement(errorMessage).getText().contains("This page has a JavaScript error");
    }

    public String getJavaScriptErrorMessage() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().toString().equals("SEVERE") && entry.getMessage().contains("TypeError")) {
                String errorMessage = entry.getMessage();
                int startIndex = errorMessage.indexOf("TypeError: ") + 11;
                int endIndex = errorMessage.indexOf(" (");
                return errorMessage.substring(startIndex, endIndex);
            }
        }
        return null;
    }

}
