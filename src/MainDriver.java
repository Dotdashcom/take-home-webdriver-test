
package com.dotDash.DotDash;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainDriver {

	public MainDriver(WebDriver driver) {
		MainDriver.driver = driver;
	}
	
	private static WebDriver driver = null;
	private static MainDriver driverClassInstance = null;
	
	public static MainDriver getInstance() {
		if  (driverClassInstance == null)
			driverClassInstance = new MainDriver(driver);
		return driverClassInstance;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver openBrowserNS(String Browser) {
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");

		}
		else {
			System.out.println("Invalid Driver");
		}
		return driver;
	}

	public WebDriver openBrowserSingleton(String Browser) {
		if(driver==null) {
			if(Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://www.google.com/");
				
			}
			else if(Browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://www.google.com/");
				
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://www.google.com/");
				
			}
			else {
				System.out.println("Invalid Driver");
			}
		}
		return driver;
	}



}