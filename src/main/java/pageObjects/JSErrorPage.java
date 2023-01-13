package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class JSErrorPage extends Base {
    WebDriver driver;

    public boolean checkForErrorInLogs(String errorToSearch) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.getAll();
        for (LogEntry logEntry : lg) {
            if (logEntry.getMessage().contains(errorToSearch)) {
                return true;
            }
        }
        return false;
    }

    public JSErrorPage(WebDriver driver) {
        this.driver = driver;
    }
}
