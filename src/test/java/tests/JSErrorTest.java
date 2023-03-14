package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class JSErrorTest {

    private static WebDriver driver;
    private static String URL = "";

    @Before
    public void beforeStart() {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        URL = RunEnvironment.getUrlBase();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void jsError() {

        String expectedResult = "http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
        String gottenResult = "";
        int iterator = 0;

        driver.get(URL + "/javascript_error");

        try {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry logEntry : logEntries) {

                if (iterator == 0)
                {
                    gottenResult = logEntry.getMessage();
                    iterator++;
                }
            }
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            gottenResult = "";
        }

        assertEquals(expectedResult,gottenResult);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
