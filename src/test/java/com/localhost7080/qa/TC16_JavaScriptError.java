package com.localhost7080.qa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC16_JavaScriptError {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC16_JavaScriptError_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/javascript_error");

		// Get the JavaScript error with manage and logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> lg = logEntries.getAll();
		// Get the first error and compare the message with the expected
		String[] msg = lg.get(0).getMessage().split("TypeError:");
		Assert.assertEquals(msg[1].trim(), "Cannot read properties of undefined (reading 'xyz')");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
