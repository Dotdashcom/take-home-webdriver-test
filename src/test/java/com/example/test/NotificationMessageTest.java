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

public class NotificationMessageTest {

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
	public void notificationMessageTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/windows");
			int numOfTries = 5; // Number of tries/clicks
			String previousMessage = null;
			boolean messageUpdated = false;

			for (int i = 0; i < numOfTries; i++) {
				// Find the link element and click on it
				WebElement linkElement = driver.findElement(By.linkText("Click here"));
				linkElement.click();

				// Wait for the message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

				// Get the message text
				String messageText = messageElement.getText();

				// Print the message for verification
				System.out.println("Message " + (i + 1) + ": " + messageText);

				// Compare with the previous message
				if (previousMessage != null && !previousMessage.equals(messageText) && (messageText.equalsIgnoreCase("Action unsuccessful, please try again")|messageText.equalsIgnoreCase("Action Unsuccessful"))) {
					messageUpdated = true;
				}

				// Update the previous message
				previousMessage = messageText;
			}
			assertTrue(messageUpdated);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
