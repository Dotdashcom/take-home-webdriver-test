package methods;

import model.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

public class JSErrorMethod extends GeneralTestMethod{
    private final String jsErrorURL = "http://localhost:7080/javascript_error";
    JSErrorPage jsErrorPage;

    public void startJSErrorTest() {
        driver.get(jsErrorURL);
        jsErrorPage = new JSErrorPage(driver);
    }

    public boolean isError(String errorMSG) {
        List<LogEntry> logs = jsErrorPage.logEntries().getAll();
        for(LogEntry log : logs) {
            if(log.toString().contains(errorMSG)) return true;
        }
        return false;
    }
}
