package specs.JavaScriptError;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #16 JavaScript Error: http://localhost:7080/javascript_error Test JS error
public class CheckJavaScriptError {
    private static WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("window-size=1920,1080", "--no-sandbox", "--incognito", "--disable-gpu", "--start-maximized");
        LoggingPreferences logPref = new LoggingPreferences();
        logPref.enable(LogType.BROWSER, Level.ALL);
        ChromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPref);

        driver = new ChromeDriver(ChromeOptions);

        // Open the targeted page
        driver.get("http://localhost:7080/javascript_error");
    }

    @Test
    public void checkJavaScriptError() {
        SoftAssert softas = new SoftAssert();

        String expMsg = "Cannot read property 'xyz' of undefined";

        boolean flag = false;

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            String actMsg = logEntry.getMessage();

            if (actMsg.contains(expMsg)) {
                flag = true;
                break;
            }

        }

        // Validate JavaScript message contains the expected value
        softas.assertTrue(flag, "JavaScript message doesn't contain the expected value");

        softas.assertAll();
    }

    @AfterMethod
    public void afterMethod(ITestResult result, ITestResult iTestResult) {

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                System.out.println(result.getMethod().getMethodName() + ": PASS");
                break;

            case ITestResult.FAILURE:
                System.out.println(result.getMethod().getMethodName() + ": FAIL");
                break;

            case ITestResult.SKIP:
                System.out.println(result.getMethod().getMethodName() + ": SKIP");
                break;

            default:
                throw new RuntimeException(result.getTestName() + "Invalid status");
        }

    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
