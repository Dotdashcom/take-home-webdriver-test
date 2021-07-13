package com.selenium.test.util;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.selenium.entity.DataSingleton;



public class Hooks {
	
	final static DataSingleton singleton = DataSingleton.getInstance();
	
	@BeforeClass
	public static void openDriver() {
		
		try {
			
			WebDriver driver = null;
			
			driver = WebDriverUtil.setDriver("chrome", LocalConfUtils.getProperty("chrome"));
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
			singleton.setWebDriver(driver);
		} catch(InterruptedException | MalformedURLException e) {
			System.out.println("Error Opening Webdriver Instance");
			System.exit(1);	
		}
		

	}
	
	@AfterClass
	public static void closeDriver() {
		singleton.getWebDriver().quit();
	}
	
	
}
