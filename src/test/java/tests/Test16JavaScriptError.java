package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class Test16JavaScriptError extends GenericTest {

    @Test
    public void Test16JavaScriptError() {
        String url = "http://localhost:7080/javascript_error";
        driver.get(url);

        //get all logs
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        Boolean errorFlag = false;
        //loop through all logs and set flag to true if specified js error message is found
        for(LogEntry log: logs) {
            System.out.println(log.getMessage());
            if (log.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
                errorFlag = true;
            }
        }
        //assert that boolean is true
        Assert.assertTrue(errorFlag);
    }

}