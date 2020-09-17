package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

import java.util.List;
import java.util.logging.Level;

import static org.testng.Assert.fail;
import static utils.Driver.getDriver;

public class JSError extends TestBase {
    String url="javascript_error";

    @Test
    public void jsError(){
        Driver.setUp(url);
        LogEntries logEntries=Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String error="";
        for(LogEntry entry:logEntries){
            error=entry.getMessage();
        }
        System.out.println(error);
        Assert.assertTrue(error.contains("Cannot read property 'xyz' of undefined"));

    }
}
