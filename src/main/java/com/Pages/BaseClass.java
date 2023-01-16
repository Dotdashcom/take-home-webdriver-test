package com.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static String projectLocation ;


	public BaseClass() {
		try {
			prop = new Properties();
			projectLocation=System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(projectLocation+"\\src\\main\\resources\\com\\testdata\\config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void startBrowser() {

		DesiredCapabilities capabilities= DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", projectLocation+"\\src\\main\\resources\\download");
		options.setExperimentalOption("prefs", chromePrefs);
		LoggingPreferences loginPref =new LoggingPreferences();
		loginPref.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loginPref);
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\src\\main\\resources\\com\\driver\\chromedriver_win32\\chromedriver.exe");
		options.merge(capabilities);
		driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); 
	}
	public static void waitforElementLocated(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

}