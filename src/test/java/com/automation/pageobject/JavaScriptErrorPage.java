package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptErrorPage {

	
	public static void captureJavaScript(WebDriver driver) {
		LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
	
		Assert.assertTrue(jsErrors.getAll().toString().contains("Cannot read property 'xyz' of undefined"));
		                                              
	}
	
}
