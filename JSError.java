package test;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class JSError extends BaseClass {

	@BeforeMethod
	
	public void openUrl() {
		initiate();
		
	}
	
	@Test
	
	public void error() {
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(30) > a")).click();
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);		
		List<org.openqa.selenium.logging.LogEntry> logs = logEntries.getAll();
		
		for(org.openqa.selenium.logging.LogEntry entry : logEntries) {
			System.out.println(entry.getMessage());
		}
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
}
