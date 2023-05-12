package com.example.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.util.TestUtil;

public class DynamicContentTest {

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
	public void dynamicContentTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/dynamic_content");

			WebElement element = driver.findElement(By.className("large-10"));

			// Get the initial text of the element
			String initialText = element.getText();

			// Refresh the page
			driver.navigate().refresh();

			// Find the element again after refreshing the page
			WebElement refreshedElement = driver.findElement(By.className("large-10"));

			// Get the text of the refreshed element
			String refreshedText = refreshedElement.getText();
			assertNotEquals(initialText, refreshedText);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
