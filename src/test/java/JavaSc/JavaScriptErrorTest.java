package JavaSc;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class JavaScriptErrorTest extends TestBase {
    @BeforeClass
    public void loginUrl() {
        driver.get(TestBase.BASEURL.concat("/javascript_error"));
    }

    @Test
    public void JavaScriptErrortest() {
        LogEntries logEntries= Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String error="";
        for(LogEntry entry:logEntries){
            error=entry.getMessage();
        }
        System.out.println(error);
      //Assert.assertTrue(error.contains("Cannot read property 'xyz' of undefined"));
    }
}

