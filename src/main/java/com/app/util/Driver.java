package com.app.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	private Driver() {

	}

	public static WebDriver getDriver() {

		String driverOption = ConfigReader.getProperty("browser");

		switch (driverOption.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new RuntimeException("No Driver Selected");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;
	}

	public static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
