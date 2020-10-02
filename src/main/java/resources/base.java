package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {
	
	public WebDriver driver;
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		//path defined for chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/satinderpalsingh/eclipse-workspace/chromedriver");
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		// Set logging preference In Google Chrome browser capability to log
		// browser errors.
		LoggingPreferences pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, pref);
		//preferences givem to driver
		driver = new ChromeDriver(cap);		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}


