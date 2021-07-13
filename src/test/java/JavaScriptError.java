import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.JavaScriptErrorPage;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class JavaScriptError {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/javascript_error");
    }

    @Test(testName = "JavaScriptError")
    public void checkThatErrorsCanBeDetected() {
        String error = "Cannot read property 'xyz' of undefined";
        JavaScriptErrorPage page = new JavaScriptErrorPage(driver);
        List<String> logs = page.getLogEntryMessages();
        for (String log : logs) {
            if (log.contains(error)) {
                assertTrue(true);
                return;
            }
        }
        fail("No Error Message Found");
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        driver.quit();
    }
}

