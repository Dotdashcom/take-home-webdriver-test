package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class JavaScriptErrorPage extends BasePage {
	private WebDriver driver;

	public JavaScriptErrorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//p[contains(text(),' This page has a JavaScript error in the onload event.')]")
	private WebElement jsHeader;
	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToJSErrorPage() {
		navigateTo(TestProperties.getProperty("JAVASCRIPT_ERRORS_URL"));
		assertEquals("Hover Page Elements Header",checkWebElementExist(jsHeader), true);
	}
	/**
	 * To Validate JS Error functionality
	 * @author Seb Geb
	 */
	
	public void validateJSErrorPage() {
		String error = "Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> lg = logEntries.filter(Level.ALL);
		for(LogEntry logEntry : lg) {
			if(logEntry.toString().contains(error)) {
				ReportUtil.logMessage(LogStatus.PASS,"Error Found in browser console",logEntry.toString());
				break;
			}
		}
	}
}
