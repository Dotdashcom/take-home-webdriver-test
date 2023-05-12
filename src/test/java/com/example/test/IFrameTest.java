package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.util.TestUtil;

public class IFrameTest {

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
	public void iFrameTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/iframe");
			WebElement bodyElement = driver
					.findElement(By.cssSelector("body[id='tinymce'][class='mce-content-body'][data-id='mce_0']"));
			bodyElement.click();

			// Clear the existing content if needed
			bodyElement.clear();

			// Type the desired text
			String textToType = "Hello, world!";
			bodyElement.sendKeys(textToType);

			// Verify the entered text
			String enteredText = bodyElement.getText();
			assertEquals(enteredText, textToType);

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
