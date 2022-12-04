package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	// singleton
	private volatile static DriverFactory driverFactory = null;

	public static DriverFactory getInstance() {
		if (driverFactory == null) {
			synchronized (DriverFactory.class) {
				if (driverFactory == null) {
					driverFactory = new DriverFactory();
				}
			}
		}
		return driverFactory;
	}
	
	/**
	 * static variable that relates an specific webdriver instance with a thread, it
	 * is like a dictionary in order to ensure thread safety.
	 */

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void createDriver(String browser) {
		browser.toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}
	}

	/** this method returns the driver related with the current thread */
	public static WebDriver getDriver() {

		return driver.get();
	}
}
