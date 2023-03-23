package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class JSError extends Constants {

    static String url = "http://localhost:7080/javascript_error";


    @Test
    public static void testJSError() {
        driver.get(url);

        //List<JavaScriptError> jsErrorList = JavaScriptError.readErrors(driver);

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.filter(Level.ALL);
        int count = 0 ;
        for(LogEntry logEntry : lg) {
            if(logEntry.getMessage().contains("xyz"))
                count++;
        }
        sa.assertEquals(count, 1);

        sa.assertAll();

    }
}
