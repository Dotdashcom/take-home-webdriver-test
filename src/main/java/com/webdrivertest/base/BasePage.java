package com.webdrivertest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author iturkmen
 *
 */
public class BasePage {
	
	Properties prop;
	public static boolean highlightElement;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	/**
	 * getDriver
	 * @author iturkmen
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	/**
	 * Provides initialize drivers
	 * @author iturkmen
	 * @param browserName
	 * @return
	 */
	public WebDriver init_driver(String browserName) {
		highlightElement = prop.getProperty("highlight").equals("yes") ? true : false;
		System.out.println("Browser name is: "+ browserName);
		optionsManager = new OptionsManager(prop);
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));	
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));	
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Browser name "+ browserName + " is not found");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();	
	}
	/**
	 * @author iturkmen
	 * @return
	 * provides getProperty function
	 */
	public Properties init_properites() {
		prop = new Properties();
		String path = null;
		String env = null;
		try {
			env = System.getProperty("env");
			if(env.equals("qa")) {
				path = "./src/main/java/com/webdrivertest/config/config.qa.properties";
			}else if(env.equals("stg")) {
				path = "./src/main/java/com/webdrivertest/config/config.stg.properties";
			}
		} catch (Exception e) {
			path = "./src/main/java/com/webdrivertest/config/config.properties";
		}
		
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		}catch (FileNotFoundException e) {
			System.out.println("some issue occured with config properties... Correct config file");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	/**
	 * Screenshot
	 * @author iturkmen
	 * @return
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.err.println("screenshot captured failed...");
		}
		return path;	
	}
	
}
