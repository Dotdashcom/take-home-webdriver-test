package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class JSErrorPage {
    JSErrorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static void retrieveJSLogs(){
        LogEntries logEntries= Driver.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs=logEntries.filter(Level.ALL);
        for(LogEntry logEntry:logs)
            Assert.assertTrue(logs.toString().contains("Cannot read property 'xyz' of undefined"));
    }
}
