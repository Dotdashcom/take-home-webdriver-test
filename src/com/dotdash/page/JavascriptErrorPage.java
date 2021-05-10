package com.dotdash.page;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavascriptErrorPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/javascript_error";

	public JavascriptErrorPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		List<LogEntry> logEntries = driver.manage().logs().get(LogType.BROWSER).getAll();
		assertTrue(logEntries.size() > 0);
		
		// Note: There is also an error logged: favicon.ico 404 Not Found
		String expectedMsg = "Cannot read property 'xyz' of undefined";
		long count = logEntries.stream().filter(le -> le.getMessage().contains(expectedMsg)).count();
		assertTrue(count > 0);
	}
}
