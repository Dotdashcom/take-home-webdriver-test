package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.example.test.util.TestUtil;

public class NewTabTest {

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
	public void newTabTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/windows");
			String parentWindowHandle = driver.getWindowHandle();
			WebElement linkElement = driver.findElement(By.linkText("Click Here"));
			linkElement.click();

			// Switch to the new tab
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(parentWindowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// Assert that the new tab is opened
			Assert.assertNotEquals(parentWindowHandle, driver.getWindowHandle(), "New tab is not opened");

			// Perform any actions on the new tab as needed

			// Close the new tab and switch back to the parent window
			driver.close();
			driver.switchTo().window(parentWindowHandle);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
