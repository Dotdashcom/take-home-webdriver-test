package TestSteps;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class Js_Error {
WebDriver driver;
	    
		 @BeforeMethod
		    public void setUp() {
		               
		        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		        LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.BROWSER, Level.ALL);
		        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); 
		        driver = new ChromeDriver(capabilities);
		    }

		    @AfterMethod
		    public void tearDown() {
		        driver.quit();
		    }
		    public void ExtractJSLogs() {
		        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		        for (LogEntry entry : logEntries) {
		            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		        }
		    }
		    @Test
		    public void testMethod() {
		        driver.get("http://localhost:7080/javascript_error");
		        ExtractJSLogs();
		    }
}
