package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.JsError;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class JsErrorTest {


    private WebDriver driver;
    private JsError jsError;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        jsError = new JsError(driver);

    }

    @Test
    public void CheckJsError() {


        LogEntries logEntries = jsError.checkJsError();

        for (LogEntry entry : logEntries) {

            System.out.println(entry.getMessage());

            if ( entry.getMessage().contains("Cannot read property 'xyz' of undefined") ) {

                assertTrue(true);
                return;

            }
        }

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
