package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSErrorPage {

	WebDriver driver;

	String ExpectedError = "Cannot read properties of undefined (reading 'xyz')";

	public JSErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyJSErrormessage() {
		LogEntries JSError = driver.manage().logs().get(LogType.BROWSER);
		
				for (LogEntry error : JSError) {
			Assert.assertTrue(error.getMessage().contains(ExpectedError));
	}

}
}
