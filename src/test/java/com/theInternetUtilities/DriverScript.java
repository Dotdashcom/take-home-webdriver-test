package com.theInternetUtilities;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import pageObjects.PageObjects;

public class DriverScript {

	public static WebDriver obj_Driver;
	public PageObjects obj_PageObject;
	public ConfigProvider obj_Properties;

	
	public WebDriver getDriver() {
		return obj_Driver;
	}
	
	public void launchBrowser() throws InterruptedException {
		if(System.getProperty("os.name").contains("Windows"))
			System.setProperty("webdriver.chrome.driver", "./Drivers/WindowsChromedriver.exe");
		else
			System.setProperty("webdriver.chrome.driver", "./Drivers/Linuxchromedriver.exe");
		  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		  chromePrefs.put("profile.default_content_settings.popups", 0);
		  chromePrefs.put("download.default_directory", System.getProperty("user.dir")+File.separator+"Downloads");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless");
		  options.setExperimentalOption("prefs", chromePrefs);
		  obj_Driver = new ChromeDriver(options);
		  obj_PageObject = new PageObjects(obj_Driver);
		  ConfigProvider.loadProperties();
		    
	  }
	
	public PageObjects getPageObject() {
		
		return obj_PageObject;
	}
	
	public void closeBrowser() {
		obj_Driver.quit();
		
	}
	
}
