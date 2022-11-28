import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JavascriptError {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","BrowserWebDrivers\\chromedriver.exe");

            driver = new ChromeDriver();
            baseUrl = "http://localhost:7080/";
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        }

        @Test
        public void TestJSError() throws Exception {
            driver.get(baseUrl + "javascript_error");
            Thread.sleep(2000);
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

            for (LogEntry logEntry : logEntries) {

                List<String> test= Arrays.asList(logEntry.getMessage().split("Uncaught TypeError:"));

                String actualError = test.get(test.size() - 1).trim();
                if(actualError.indexOf("xyz") > 0 ){
                    String expectedError = "Cannot read properties of undefined (reading 'xyz')";
                    Assert.assertEquals(actualError, expectedError);
                }

            }

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}