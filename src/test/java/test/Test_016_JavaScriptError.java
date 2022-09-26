package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class Test_016_JavaScriptError extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/javascript_error");
    }

    @Test
    public void TC001_JsErrorTesting() {
        LogEntries entries = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> log = entries.getAll();
        String[] error = log.get(0).getMessage().split("TypeError:");
        Assert.assertEquals(error[1].trim(), "Cannot read properties of undefined (reading 'xyz')");
        System.out.println(Arrays.toString(error));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
