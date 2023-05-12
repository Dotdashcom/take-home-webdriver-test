package com.example.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.test.util.TestUtil;

public class DropdownTest {

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
	public void dropdownTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/dropdown");

			WebElement dropdown = driver.findElement(By.id("dropdown"));

			// Create an instance of Select class
			Select select = new Select(dropdown);

			// Select Option 1
			select.selectByValue("1");

			// Verify Option 1 is selected
			assertTrue((select.getFirstSelectedOption().getText().equals("Option 1")));

			// Select Option 2
			select.selectByValue("2");

			// Verify Option 2 is selected
			assertTrue(select.getFirstSelectedOption().getText().equals("Option 2"));

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
