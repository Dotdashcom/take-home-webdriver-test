package com.example.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.test.util.TestUtil;

public class DynamicLoadingTest {

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
	public void dynamicControlAddAndRemoveTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/dynamic_loading/2");
			WebElement startButton = driver.findElement(By.cssSelector("#start button"));

			startButton.click();

			// Wait until the "finish" element is displayed
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement finishElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

			// Verify that the "finish" element contains the text "Hello World!"
			String finishText = finishElement.getText();
			assertEquals(finishText, "Hello World!");
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
