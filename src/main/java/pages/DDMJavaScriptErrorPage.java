package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.List;
public class DDMJavaScriptErrorPage extends DDMBasePage  {

    public DDMJavaScriptErrorPage(WebDriver driver)  {
        super(driver);
    }

    public boolean javaScriptErrorMessage()  {
        LogEntries allLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = allLogs.getAll();
        boolean found = false;

        for(LogEntry currentLog : logs)  {
            if(currentLog.getMessage().contains("Cannot read properties of undefined (reading 'xyz')"))  {
                found = true;
            }
        }
        return found;
    }
}