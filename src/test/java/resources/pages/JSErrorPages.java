package resources.pages;

import resources.utilities.BaseClass;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JSErrorPages extends BaseClass {

    public void userCheckJSError() {

        Set<String> errorStrings = new HashSet<>();
        errorStrings.add("SyntaxError");
        errorStrings.add("EvalError");
        errorStrings.add("ReferenceError");
        errorStrings.add("RangeError");
        errorStrings.add("TypeError");
        errorStrings.add("URIError");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            for (String errorString : errorStrings) {

                if (logEntry.getMessage().contains(errorString)) {
                    System.out.println(logEntry.getMessage());
                    boolean flag=(logEntry.getMessage()).contains(prop.getProperty("JSErrorMsg"));
                    System.out.println(flag);
                }
            }
        }
    }
}
