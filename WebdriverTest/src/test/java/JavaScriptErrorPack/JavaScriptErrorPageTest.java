package JavaScriptErrorPack;
import Main.Package.JavaScriptErrorPage;
import bsh.Console;
import bsh.util.JConsole;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.ErrorManager;
import java.util.logging.Level;

public class JavaScriptErrorPageTest {
    private WebDriver driver;
    private JavaScriptErrorPage javaScriptErrorPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    public void extractJSLogInfo() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + "" + entry.getLevel() + "" + entry.getMessage());

        }


    }

    @Test

    public void TestMethod() throws Exception {


        driver.get("http://localhost:7080/javascript_error");
        LogEntries jsErrors =driver.manage().logs().get(LogType.BROWSER);
        System.out.println("Print All Log" + jsErrors.getAll());
        System.out.println("Print index0 Log" +jsErrors.getAll().get(0));

        Thread.sleep(5);
        Assert.assertTrue(jsErrors.getAll().get(0).toString().contains(" Cannot read properties of undefined (reading 'xyz')"));

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
