package com.homedriver;

import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test Iframe.
	@Test
	public void text_switchedsToIframe_check() {
		driver.get(configFileReader.getBaseUrl() + "/iframe");
		String enterText = "test Iframe";

		By textField = By.id("tinymce");

		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(textField).sendKeys(enterText);
		assertTrue(driver.findElement(textField).getText().contains(enterText));
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
