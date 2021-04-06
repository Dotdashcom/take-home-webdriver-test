package TakeHome.pages;


import TakeHome.utilities.Driver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Level;

public class JSErrorPage extends BasePage {
    public JSErrorPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public static List<LogEntry> retrieveJSLogs() {
        LogEntries logEntries = Driver.get().manage().logs().get(LogType.BROWSER);
        return logEntries.filter(Level.ALL);
    }
}
