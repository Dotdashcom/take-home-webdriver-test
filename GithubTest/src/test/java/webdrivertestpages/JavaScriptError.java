package webdrivertestpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Level;

public class JavaScriptError {
    WebDriver driver;

    public JavaScriptError(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String javascriptError() {

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.ALL);
        // using for each loop
        for (LogEntry logEntry : logs) {
            System.out.println(logEntry);
            String message = logEntry.getMessage();
            return message;
        }
        return null;
    }
}
