package com.takeHomeTest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.takeHomeTest.Browser.Browser;
import com.takeHomeTest.Utils.ProxyDriver;
import com.takeHomeTest.Utils.WebDriverEvents;
import com.takeHomeTest.env.EnviornmentUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webDriver;
	public Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;
	private static final Browser DEFAULT_BROWSER = Browser.GOOGLE_CHROME;

	private static final EnviornmentUtils ENV = EnviornmentUtils.PRODUCTION;

	public TestBase() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./src\\main\\java\\com\\takeHomeTest\\Config\\config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// initializing logger 
	
	@BeforeClass
	public void loggerSetUp() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
	}

	public void intialization() {
		
		// Manages the driver for the browser on which testing is performed

		switch (DEFAULT_BROWSER.getBrowsername()) {
		case "Chrome":
			webDriver = new ProxyDriver(WebDriverManager.chromedriver().create());
			break;
		case "Firefox":
			webDriver = new ProxyDriver(WebDriverManager.firefoxdriver().create());
			break;
		case "MicrosoftEdge":
			webDriver = new ProxyDriver(WebDriverManager.edgedriver().create());
			break;

		default:
			System.out.println(("Verify you have passed the correct browser name"));
			break;
		}

		/*
		 * e_driver = new EventFiringWebDriver(webDriver); events = new
		 * WebDriverEvents(); e_driver.register(events);
		 * 
		 * webDriver = e_driver;
		 */

		// managing the environment 
		switch (ENV) {
		case Dev:
			webDriver.get(prop.getProperty("base_dev_url"));
			break;
		case STAGE:
			webDriver.get(prop.getProperty("base_stage_url"));
			break;
		case PRODUCTION:
			webDriver.get(prop.getProperty("base_url"));
			break;
		default:
			System.out.println("Not a correct case");

			break;
		}
		webDriver.manage().window().maximize();

		webDriver.manage().deleteAllCookies();
	}

	public void quitBrowser() {
		webDriver.quit();
	}
}
