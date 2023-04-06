package com.homewebdriver.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class JavaScriptErrorPage {
    WebDriver driver;

    private static String JAVASCRIPT_ERROR_URL="http://localhost:7080/javascript_error";

    @FindBy(xpath = "//p")
    public WebElement errorText;


    public JavaScriptErrorPage(WebDriver driver){
        this.driver=driver;
        driver.get(JAVASCRIPT_ERROR_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
    
    public String verifyJSError() {
        Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
        for (String s : logTypes) {
            System.out.println(s);
        }
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        for (LogEntry logEntry : logs) {
            System.out.println(logEntry);
        }
        return errorText.getText();
    }
}
