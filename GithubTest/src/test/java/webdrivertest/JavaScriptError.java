package webdrivertest;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Level;

@Test
public class JavaScriptError extends Base {
    WebDriver driver;
    public void javascriptError(){
        driver = getDriver();
        driver.get("http://localhost:7080/javascript_error");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.ALL);
        // using for each loop
        for(LogEntry logEntry : logs){
            System.out.println(logEntry);
        }

    }
}
