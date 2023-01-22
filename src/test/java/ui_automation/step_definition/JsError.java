package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui_automation.pages.CheckBoxesPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

public class JsError {

    WebDriver driver;


    @Given("user navigate to the JSError URL and user verify all the Js Error in the background")
    public void user_navigate_to_the_JSError_URL_and_user_verify_all_the_Js_Error_in_the_background() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver(desiredCapabilities);

        String JsError = (ConfigurationReder.getProperties("ui-config.properties", "JsError"));
        driver.get(JsError);

        String actual = null;
        LogEntries logEntries = (driver.manage().logs().get(LogType.BROWSER));
        String expectedMsg = "Cannot read properties of undefined (reading 'xyz')";
        System.out.println("Log enteris : " + logEntries.getAll().size());

        Iterator<LogEntry> i = logEntries.iterator();
        String firstLog = i.next().toString();
        System.out.println("first: " + firstLog);
        System.out.println("size of first: " + firstLog.length());
        actual = firstLog.substring(100, firstLog.length());
        System.out.println("acual : " + actual);
        Assert.assertEquals(expectedMsg, actual);
        driver.quit();

    }


}
