package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import com.app.util.PageLinks;

public class JsErrorPage extends BasePage {

	public JsErrorPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void visitJsErrorPage() {
		getDriver().get(PageLinks.JS_ERRORS_PAGE);
	}
	
	@SuppressWarnings("deprecation")
	public void verifyJsError() {
		WebDriver driver = getDriver();
		String expectedErrStr = "Cannot read property 'xyz' of undefined";
		 Logs logs = driver.manage().logs();
	        LogEntries logEntries = logs.get(LogType.BROWSER);
	       
	        for (LogEntry entry : logEntries) {
	        	
	        	String errorLog= entry.getMessage().toString();
	        	
	        	if (errorLog.contains(expectedErrStr)) {
					assertTrue(true);
					return;
				}
	        }
	      assertTrue(false, "Page does not contain any error from console");     
	}

}
