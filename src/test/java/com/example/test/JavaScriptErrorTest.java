package com.example.test;

import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;

import com.example.test.util.TestUtil;

public class JavaScriptErrorTest {

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
			driver.get("http://localhost:7080/javascript_error");
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
//			((Object) driver.manage().logs()).setLogLevel(LogType.BROWSER, Level.ALL);

			// Navigate to the page or perform actions that trigger JavaScript execution

			// Get browser logs
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

			// Iterate through log entries
			boolean errorFound = false;
			for (LogEntry entry : logEntries) {
				if (entry.getLevel() == Level.SEVERE
						&& entry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
					// Error message found
					errorFound = true;
					break;
				}
			}

			// Assert that the error is found
			Assert.assertTrue(errorFound, "Error message not found: Cannot read property 'xyz' of undefined");

		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
