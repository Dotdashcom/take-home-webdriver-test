package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass extends helpers {

	public Properties prop;
	public static String username;
	public String password;
	public String browser;

	public Baseclass() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./configureFile");
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Error occured while loading the properties file");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Error occured while loading the properties file");
		}
	}

	public void launchApplication(String endpoint) {
		// Manages the driver for the browser on which testing is performed
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		browser = prop.getProperty("browser").toLowerCase();
		switch (browser) {
			case "chrome":
//				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "headlesschrome":
//				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--window-size=1200x600");
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
				break;
			default:
				throw new RuntimeException("Correct browser name is not passed: " + browser);
		}
		
		driver.manage().window().maximize();
		String url = prop.getProperty("base_url");
		url = url + endpoint;
		driver.get(url);
		takeScreenshot();
	}

	public void endTestExecution() 
	{
		driver.quit();
		System.out.println("test case execution completed");
	}

	
}
