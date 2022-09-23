package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class JavaScriptErrorPage extends AbstractWebPage {

    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public boolean doesPageErrorContains(String errorMessage){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        for(LogEntry logEntry: logs){
            if(logEntry.getMessage().contains(errorMessage)) {
                return true;
            }
        }
        return false;
    }
}
