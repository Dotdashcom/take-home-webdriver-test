package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.util.TestUtil;

public class AlertTest {

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
	public void AlertTest1() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/javascript_alerts");
			WebElement buttonElement = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
			buttonElement.click();

			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Get the alert message
			String alertMessage = alert.getText();
			assertEquals(alertMessage, "I am a JS Alert");
			alert.accept();

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void confirmTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/javascript_alerts");
			WebElement buttonElement = driver
					.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
			buttonElement.click();

			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Get the alert message
			String confirmMessage = alert.getText();
			assertEquals(confirmMessage, "I am a JS Confirm");
			alert.accept();

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void promptTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/javascript_alerts");
			WebElement buttonElement = driver
					.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]"));
			buttonElement.click();

			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Enter text in the prompt
			String textToEnter = "Your text goes here";
			alert.sendKeys(textToEnter);

			// Accept the prompt
			alert.accept();

			// Retrieve the text from the <p> element
			WebElement resultElement = driver.findElement(By.id("result"));
			String resultText = resultElement.getText();
			assertEquals(resultText, "You entered: " + textToEnter);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
