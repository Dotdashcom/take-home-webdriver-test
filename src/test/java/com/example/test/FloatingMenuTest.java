package com.example.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.util.TestUtil;

public class FloatingMenuTest {

	WebDriver driver;
	TestUtil testUtil = new TestUtil();

	@Before
	public void setUp() {
		// Set the path to the ChromeDriver executable
		try {
			System.setProperty(testUtil.getDriverName(), testUtil.getDriverPath());
			driver = testUtil.getDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// Handle exception if WebDriver setup fails
			System.out.println("Exception occurred while setting up WebDriver: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		try {
			// Close the browser and clean up resources
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			// Handle exception if browser closure fails
			System.out.println("Exception occurred during browser closure: " + e.getMessage());
		}
	}

	@Test
	public void floatingMenuTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/floating_menu");
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement divElement = driver
					.findElement(By.xpath("//div[contains(text(), 'Powered by Elemental Selenium')]"));
			boolean isVisible = divElement.isDisplayed();
			assertTrue(isVisible);
			WebElement linkElement = driver.findElement(By.linkText("Home"));
			boolean isDisplayed = linkElement.isDisplayed();
			assertTrue(isDisplayed);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
