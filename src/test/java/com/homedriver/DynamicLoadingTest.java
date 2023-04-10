package com.homedriver;

import static org.junit.Assert.assertEquals;

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

public class DynamicLoadingTest {
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

	// Test Dynamic Loading using Explict Waits.
	@Test
	public void dynamicLoading_waitInLoading_check() {
		driver.get(configFileReader.getBaseUrl() + "/dynamic_loading/2");
		driver.findElement(testHelperMethods.getLocatorUsingBtnText("Start")).click();

		By finishText = By.id("finish");
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(finishText));
		assertEquals(configFileReader.getDynamicLoadingText(), driver.findElement(finishText).getText());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
