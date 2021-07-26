package com.dotDash.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotDash.qa.base.TestBase;

public class JavaScriptErrorPage extends TestBase {

	// Finding the JavaScript Error page
	@FindBy(xpath = "//a[@href='/javascript_error']")
	WebElement jsError;

	// Initializing the Page Objects:
	public JavaScriptErrorPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// JavaScript Error test function
	public boolean containsJsError(String errorText) {
		jsError.click();

		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : entries) {
			String message = entry.getMessage().trim();
			if (message.contains(errorText)) {
				return true;
			}
		}
		return false;
	}
}
