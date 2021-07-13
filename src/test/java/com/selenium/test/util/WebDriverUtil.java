package com.selenium.test.util;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverUtil  {

	public static WebDriver driver = null;
	public static RemoteWebDriver remotedriver = null;
	

	public static WebDriver setDriver(String browserType, String executablePath) throws InterruptedException, MalformedURLException{


		if(browserType.equals("mozilla") )
		{
			
			System.setProperty("webdriver.gecko.driver", executablePath);
			driver = new FirefoxDriver();
			return driver;
		}
		
		else if(browserType.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver","src" + File.separator + "test" + File.separator + "resources" + File.separator +"chromedriver.exe"); 
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver driver = new ChromeDriver(cap);
			return driver;
			
		}
		else if(browserType.equals("headless"))
		{
			
			System.setProperty("webdriver.chrome.driver",executablePath);  
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver driver = new ChromeDriver(cap);
			return driver;
			
		}
		else if(browserType.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver",executablePath);
			driver= new InternetExplorerDriver();
			return driver;
		}
		else{
			System.out.println("Browser Type is not a valid entry : " + browserType);
			System.exit(1);
		}
		return driver;
		
	}

	
}
