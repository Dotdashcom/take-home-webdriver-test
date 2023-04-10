package com.homedriver;

import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavasScriptErrorTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test JS error.
	@Test
	public void javaScriptError_check() {
		driver.get(configFileReader.getBaseUrl() + "/javascript_error");
		assertTrue(
				driver.findElement(By.xpath("//body[@onload='loadError()']")).getText().contains("JavaScript error"));
		assertTrue(driver.manage().logs().get(LogType.BROWSER).getAll().toString()
				.contains("TypeError: Cannot read properties of undefined (reading 'xyz')"));
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
