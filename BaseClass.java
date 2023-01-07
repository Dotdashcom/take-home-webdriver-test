package com.dotdashcom.takehomewebdrivertest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	
	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/dotdashcom/takehomewebdrivertest/config/config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
	//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gkarmakar\\Downloads\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		else if(browserName.equals("Edge")){
			WebDriverManager.chromedriver().setup();
	//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gkarmakar\\Downloads\\geckodriver.exe");	
			driver = new EdgeDriver();
		}
		
		else if(browserName.equals("IE")){
			WebDriverManager.iedriver().setup();
	//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gkarmakar\\Downloads\\geckodriver.exe");	
			driver = new InternetExplorerDriver();
		}
		
		 else if(browserName.equals("HeadlessChrome")){
	            WebDriverManager.chromedriver().setup();
	    //        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gkarmakar\\Downloads\\chromedriver.exe");   
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--headless");
	            driver = new ChromeDriver(options);
	           
	        }
	/*	e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;   */
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		
	  //  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	

}
