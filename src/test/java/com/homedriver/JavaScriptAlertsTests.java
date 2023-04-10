package com.homedriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestHelperMethods;

public class JavaScriptAlertsTests {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;
	private static TestHelperMethods testHelperMethods;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
		testHelperMethods = new TestHelperMethods();
	}

	// Test confirm JS Alert.
	@Test
	public void javaScriptAlerts_checks() {
		driver.get(configFileReader.getBaseUrl() + "/javascript_alerts");
		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Click for JS Alert")).click();
		assertEquals("I am a JS Alert", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Click for JS Confirm")).click();
		assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Click for JS Prompt")).click();
		String enterText = "test JS Alerts";
		driver.switchTo().alert().sendKeys(enterText);
		driver.switchTo().alert().accept();
		assertTrue(driver.findElement(By.id("result")).getText().contains(enterText));
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
