package com.example.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.example.test.util.TestUtil;

public class HoverTest {

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
	public void hoverTest1() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/hovers");
			WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));

			// Create an instance of Actions class
			Actions actions = new Actions(driver);

			// Hover over the element
			actions.moveToElement(elementToHover).perform();

			// Verify the presence of the text
			WebElement textElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/h5"));
			boolean isDisplayed = textElement.isDisplayed();
			assertTrue(isDisplayed);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void hoverTest2() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/hovers");
			WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/img"));

			// Create an instance of Actions class
			Actions actions = new Actions(driver);

			// Hover over the element
			actions.moveToElement(elementToHover).perform();

			// Verify the presence of the text
			WebElement textElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/h5"));
			boolean isDisplayed = textElement.isDisplayed();
			assertTrue(isDisplayed);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

	@Test
	public void hoverTest3() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/hovers");
			WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));

			// Create an instance of Actions class
			Actions actions = new Actions(driver);

			// Hover over the element
			actions.moveToElement(elementToHover).perform();

			// Verify the presence of the text
			WebElement textElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/h5"));
			boolean isDisplayed = textElement.isDisplayed();
			assertTrue(isDisplayed);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
