package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptErrorPage extends BasePage {
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    private List<String> errors =new ArrayList<>();

    private void populateErrors(){
        LogEntries allBrowserLogs = getDriver().manage().logs().get(LogType.BROWSER);

        List<LogEntry> logs = allBrowserLogs.getAll();
        for(LogEntry currentLog : logs){
            errors.add(currentLog.getMessage());
        }
    }

    public boolean isErrorPresent(String requiredError) {
        populateErrors();
        for(String errorEntry: errors) {
            if(errorEntry.contains(requiredError)) {
                return true;
            }
            break;
        }
        return false;
    }
}
