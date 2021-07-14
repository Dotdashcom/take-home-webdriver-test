package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC016_jsErrorObject;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC016_jsErrorTest extends base{
	@BeforeTest
	public void setup() {
		capability = DesiredCapabilities.chrome();
		LoggingPreferences loggingPreferences = new LoggingPreferences();
		loggingPreferences.enable(LogType.BROWSER, Level.ALL);
		capability.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator +"drivers"+File.separator+"chromedriver");
		driver = new ChromeDriver(capability);
		//to load the whole page according to its complexity
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:7080/");
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC016_jsErrorObject jseo = new TC016_jsErrorObject(driver);
		jseo.getAlertLink();
		LogEntries LogEntries= driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry:LogEntries) {
			if(entry.getMessage().contains("Cannot read property 'xyz' of undefined.")) {
				AssertJUnit.assertTrue(true);
				break;
			}else {
				//message not found
				AssertJUnit.assertFalse(false);
			}
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
