package JavaScriptErrorPack;
import Main.Package.JavaScriptErrorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Date;
import java.util.logging.Level;

public class JavaScriptErrorPageTest {
    private WebDriver driver;
    private JavaScriptErrorPage javaScriptErrorPage;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "/Users/nr903/eclipse-workspace/take-home-webdriver-test/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        driver = new ChromeDriver();
    }

    @AfterMethod
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

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
