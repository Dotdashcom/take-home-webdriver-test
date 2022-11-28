package TestBase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Browser.BrowserUtilities;
import Utilities.ConfigDriver.ConfigDriver;

import Utilities.Listeners.WebEventListener;

public class BaseTest  {
	public static String appURL,username,password,driverPath,testURL;
    public static WebDriver driver;
    public static BrowserUtilities utilities;
    public static WebEventListener eventListener;
    public static EventFiringWebDriver edriver;
    public static Logger log4j = Logger.getLogger(BaseTest.class.getName());
    public static ConfigDriver configDriver;
	public File folder;

	@BeforeSuite
    public static void fnGetSystemParameter() {
    	try
    	{
    		configDriver = new ConfigDriver();
    		appURL = configDriver.getProperty("applicationURL");
    		username = configDriver.getProperty("userName");
    		password = configDriver.getProperty("password");
    		driverPath= configDriver.getProperty("chromePath");    		
    	}
    	catch(IOException iox)
    	{
    		iox.getStackTrace();
    	}
    }
    
    @SuppressWarnings("deprecation")
	@BeforeClass
    public void fnInitialize () {
    	System.out.println(driverPath);
    	System.setProperty("webdriver.chrome.driver", driverPath);
    	ChromeOptions options = new ChromeOptions();
    	
    	folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
    	
    	Map<String, Object>  prefs = new HashMap<String,Object>();
    	prefs.put("profile.default_content_settingss.popups", 0);
    	prefs.put("download.default_directory", folder.getAbsolutePath());
    	
    	options.setExperimentalOption("prefs", prefs);
    	options.setExperimentalOption("w3c", false);
    	DesiredCapabilities cap = DesiredCapabilities.chrome();
    	
    	LoggingPreferences loggingPreferences = new LoggingPreferences();
    	loggingPreferences.enable(LogType.BROWSER, Level.ALL);
    	
    	cap.setCapability(ChromeOptions.CAPABILITY, options);
    	cap.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
    	    	
	    driver = new ChromeDriver(cap);
		edriver= new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		edriver.register(eventListener);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public static String getURL(String path) {
    	testURL= appURL+path;
    	return testURL;
    
    }
    
   /* @AfterMethod
    public static void fnEndReport(TestResult,result) 
    {
    	String[] resultName;
    	try
    	{
    		If(ExtentTestManager.getTest().getRunStatus().toString().equalsIgnoreCase("Pass"))
    		{
    			If(result.getStaus()==ITestResult.SUCCESS)
    			{
    				resultName = result.getName().split("");
    				ExtentTestManager.getTest.log(LogStatus.PASS,resultName[0]+"has passed");
    			}
    			else if(result.getStatus() == ITestResult.FAILURE)
    			{
    				resultName = result.getName().split("");
    				Utilities.fnscreenshot(resultName[0]);
    				
    			}
    		}
    	}
    }
    */
    
    @AfterClass
    public void teardown () {
        driver.close();
        driver.quit();
    }

}
