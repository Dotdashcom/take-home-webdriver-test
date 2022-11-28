package Test_Cases;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.JavaScriptErrorPage;
import TestBase.BaseTest;

public class JavaScriptErrorPageTest extends BaseTest {
	JavaScriptErrorPage JSErrorPage;

	public JavaScriptErrorPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		JSErrorPage = new JavaScriptErrorPage();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void jsError() {
		//Log.info("Trying to logging into the application.");
		// logging into application
		JSErrorPage.getUrl();

	/*	// assertion for page title
		String actualPageTitle = JSErrorPage.getTitle();
		System.out.println(actualPageTitle);
		String expectedpageTitle = "Page with JavaScript errors on load";
		Assert.assertTrue(actualPageTitle.equalsIgnoreCase(expectedpageTitle));*/


        //getting all the log types in the window
		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
		for (String string: logTypes) {
			System.out.println(string);
		}
		

		//String expectedErrorMessage = "Cannot read properties of undefined (reading 'xyz')";
		
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.filter(Level.ALL);
		
		for(LogEntry logEntry : logs) {
			System.out.println(logEntry);
			System.out.println(logEntry.toString());
		}
		
		
        //And do the assertion
       System.out.println(logs.toString());
      //  Assert.assertEquals(errorTextJS.toString(), "Cannot read properties of undefined (reading 'xyz')");
    }
}
