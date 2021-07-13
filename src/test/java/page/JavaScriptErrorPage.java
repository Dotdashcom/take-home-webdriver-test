package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptErrorPage extends PageObject {
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getLogEntryMessages() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<String> logs = new ArrayList<String>();
        for (LogEntry entry : logEntries) {
            logs.add(entry.getMessage());
        }
        return logs;
    }
}
