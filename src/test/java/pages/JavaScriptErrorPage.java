package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

public class JavaScriptErrorPage extends BasePage {

    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getJsErrorMessage(){
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        String message = "no error";
        for (LogEntry log : logs) {
            if (log.getLevel() == Level.SEVERE) {
                message = log.getMessage();
            }
        }
        System.out.println(message);
        return message;
    }
}
