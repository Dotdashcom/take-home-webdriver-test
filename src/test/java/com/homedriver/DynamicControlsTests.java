package com.homedriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestHelperMethods;

public class DynamicControlsTests {
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

	// Test Dynamic Controls using Explicit Waits.
	@Test
	public void dynamicControls_addAndRemove_enableAndDisable_check() {
		driver.get(configFileReader.getBaseUrl() + "/dynamic_controls");

		By checkboxSelector = By.xpath("//*[@id='checkbox']");

		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Remove")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.numberOfElementsToBe(checkboxSelector, 0));
		assertEquals(0, driver.findElements(checkboxSelector).size());

		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Add")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.numberOfElementsToBe(checkboxSelector, 1));
		assertEquals(1, driver.findElements(checkboxSelector).size());

		By textBoxSelector = By.xpath("//*[@id='input-example']/input");

		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Enable")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(textBoxSelector));
		assertTrue(driver.findElement(textBoxSelector).isEnabled());

		driver.findElement(By.xpath("//*[@id='input-example']/button[text()='Disable']")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(textBoxSelector), "disabled"));
		assertFalse(driver.findElement(textBoxSelector).isEnabled());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
