package page_object_model.javascript_error_page;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class JavaScriptErrorPage extends Base {
    public JavaScriptErrorPage() {
        PageFactory.initElements(driver, this);
    }
    public String getJsError() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<String> result = new ArrayList<>();

// Iterate through the log entries and handle any JavaScript errors
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getLevel() == Level.SEVERE) {
//                System.out.println(logEntry.getMessage());
                result.add(logEntry.getMessage());
            }
        }
        for (String error:
             result) {
            if(error.contains("Cannot read properties of undefined (reading 'xyz')")){
              String message=error.substring(error.indexOf("Cannot"));
                System.out.println(message);
               return message;
            }
        }
        return null;
    }

}
