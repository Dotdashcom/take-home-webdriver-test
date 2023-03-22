package com.QA.BaseUtils;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;	
	public static DesiredCapabilities capabilities;

	public static WebDriver setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();

			ChromeOptions cOption = new ChromeOptions();	
			cOption.addArguments("--incognito");
			cOption.addArguments("--disable-notifications");		
			cOption.addArguments("--disable-popup-blocking");		

			
			Map<String, Object> chromePreferences = new HashMap<>();
			chromePreferences.put("download.default_directory", Constants.DOWNLOAD_DIR);
			chromePreferences.put("download.prompt_for_download", false);
			chromePreferences.put("credentials_enable_service", false);
			cOption.setExperimentalOption("prefs", chromePreferences);
			cOption.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

//			cOption.addArguments("--ignore-certificate-errors");
//			cOption.addArguments("--disable-extensions");
//			cOption.addArguments("--disable-web-security");
//			cOption.addArguments("--no-sandbox");
//			cOption.addArguments("--unsafely-treat-insecure-origin-as-secure=https://testQA.QA.com");
			
			if (ConfigsReader.getProperty("headless").equalsIgnoreCase("yes")) {
				cOption.addArguments("--headless=new");
			}
			driver = new ChromeDriver(cOption);
			break;

		default:
			throw new RuntimeException("Browser is not supported");
		}

		if (ConfigsReader.getProperty("maximizeWindow").equalsIgnoreCase("yes")) {
			driver.manage().window().maximize();
		}
		
		Dimension dimension = new Dimension(1920, 1080);
		driver.manage().window().setSize(dimension);
		

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

		PageInitializer.initialize();

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
