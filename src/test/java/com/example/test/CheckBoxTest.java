package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.example.test.util.TestUtil;

public class CheckBoxTest {

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
	public void checkboxTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/checkboxes");

			WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
			WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));

			Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 is not selected");
			Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is  selected");
			checkbox2.click();
			Assert.assertFalse(checkbox2.isSelected(), "Checkbox 2 is not selected");
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
