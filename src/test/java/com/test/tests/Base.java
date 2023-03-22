package com.test.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public WebDriver driver;

	public void initializeDriver() {
		if (this.driver == null) {
			System.setProperty("webdriver.gecko.driver", "./ext/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://localhost:7080/");
		}
	}

	public void quitDriver() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}
}
