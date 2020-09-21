package tests;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;

public class JavaScriptErrorTest extends Base {

//	Test finds the JavaScript error on the page.
//	Test asserts that the page contains error: Cannot read property 'xyz' of undefined.

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/javascript_error");
	}

	// Test finds the JavaScript error on the page.
	// Test asserts that the page contains error: Cannot read property 'xyz' of
	// undefined.

	@Test

	public void jsError() {

		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();

		for (String Types : logTypes) {
			System.out.println(Types);

		}

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

		List<LogEntry> logs = logEntries.filter(Level.ALL);

		String jsError = "";
		for (LogEntry logEnt : logs) {

			jsError = logEnt.getMessage();
			System.out.println(logEnt);
		}

		Assert.assertTrue(jsError.contains("Cannot read property 'xyz' of undefined."));
	}

}
