package com.selenium.tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSErrorTest extends TestBase {

	@Test
	public void jsError() {
		String error = "Cannot read properties of undefined (reading 'xyz')";
		driver.get("http://localhost:7080/javascript_error");

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		boolean result = false;
		for(LogEntry entry : logEntries){
			if(entry.getMessage().contains(error)) {
				result = true;
			}
		}
		Assert.assertTrue(result);
	}
}