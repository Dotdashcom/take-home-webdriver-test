package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import util.Testutil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static ChromeOptions options;
	public static DesiredCapabilities cap;
	public static File folder;
	
	public TestBase() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(
					//fetching the config properties file stored in the project location
					
					"C:\\Selenium_MyPractise\\KevalDotDash\\src\\main\\java\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void initialization() throws InterruptedException {
		
		//create a object of file on given location 
		
		folder = new File("C:\\Selenium_MyPractise\\KevalDotDash\\src\\main\\java\\testdata");
		
		//making a directory
		
		 folder.mkdir();
		 
		 //reading from the config file
		 
		String browsername = prop.getProperty("browser");	
		if (browsername.equalsIgnoreCase("chrome")) {
			
			//based on browser value setting up the properties of chrome browser
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_MyPractise\\KevalDotDash\\chromedriver.exe");		 
			
			//use ChromeOptions class for download a file on specific folder
			
			options = new ChromeOptions();	
			
			//creating hashmap object to store the default settings
			
			Map<String,Object> hm = new HashMap<String,Object>();
			
			hm.put("profile.default_content_setings.popups",0);
			
			hm.put("download.default_directory" ,folder.getAbsolutePath());
			
			//passing the map reference variable in ChromeOptions
			
			options.setExperimentalOption("prefs", hm);
			
			//setting up the desired capabilities 
			
			 cap = DesiredCapabilities.chrome();
			 
			 //use LoggingPreferences class create a log feature to capture javascript errors
			 
			 LoggingPreferences logginPreferences  = new LoggingPreferences();
			 
			 //setting up parameters to get log of browser type 
			 logginPreferences.enable(LogType.BROWSER, Level.ALL);
			 
			 cap.setCapability(CapabilityType.LOGGING_PREFS, logginPreferences);
			 
			 cap.setCapability(ChromeOptions.CAPABILITY, options);
			 
			 //invoking the ChromeDriver Object
			driver = new ChromeDriver(cap);		
		} 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageloadtimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicitlywait, TimeUnit.SECONDS);
	}
	
	
}
