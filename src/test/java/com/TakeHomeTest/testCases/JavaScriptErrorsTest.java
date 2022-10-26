package com.TakeHomeTest.testCases;

import java.sql.Date;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.logging.LogEntry;


public class JavaScriptErrorsTest extends BaseClass{

	@Test
	public void OnloadError() {
		driver.get(url+"/javascript_error");
		
		LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);

		
		for (LogEntry entry : logEntries) {
			System.out.println(entry);
        }
		Assert.assertTrue(logEntries.getAll().get(1).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
	}
}
