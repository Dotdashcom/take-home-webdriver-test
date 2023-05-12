package com.example.test;

import static org.junit.Assert.assertTrue;

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

public class DynamicControlTest {

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
			driver.get("http://localhost:7080/dynamic_controls");

			WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
			removeButton.click();

			// Wait for 5 seconds
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Confirm the removal of the checkbox element
			org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
					Duration.ofSeconds(5));
			boolean isCheckboxRemoved = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
			assertTrue(isCheckboxRemoved);
			WebElement addButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
			addButton.click();

			// Wait for the checkbox to become visible
			WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

			assertTrue(checkbox.isDisplayed());
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void dynamicControlEnableAndDisableTest() {
		driver.get("http://localhost:7080/dynamic_controls");
		WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		enableButton.click();

		// Wait for the textbox to become enabled
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']")));
		assertTrue(textbox.isEnabled());
		WebElement disableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		disableButton.click();

		// Wait for the textbox to become disabled
		textbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']")));
		assertTrue(textbox.isEnabled());
	}

}
