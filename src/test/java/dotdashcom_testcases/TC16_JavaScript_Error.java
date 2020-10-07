package dotdashcom_testcases;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC16_JavaScript_Error extends BaseTest {

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {

		// receiving url to the browser
		driver.get("http://localhost:7080/javascript_error");
	}

	@Test
	public void ExtractJSLogs() {

		// getting javascript errors in the page using logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {

			// receiving and printing javascript error messages in the console
			String string = entry.getMessage();
			System.out.println(string);

			// asserting the text "Cannot read property 'xyz' of undefined" present in the
			// list of javascript errors or not
			// split function is used to split the 1st error to assert the expected text
			// "Cannot read property 'xyz' of undefined"
			if (string.contains("Cannot read property 'xyz' of undefined")) {
				String[] parts = string.split(":");
				String part1 = parts[0]; //// http
				String part2 = parts[1]; // localhost:7080
				String part3 = parts[2]; // javascript_error 6
				String part4 = parts[3]; // 51 Uncaught TypeError
				String part5 = parts[4]; // Cannot read property 'xyz' of undefined
				Assert.assertEquals(" Cannot read property 'xyz' of undefined", part5);
				System.out.println("Assertion Passed");

			}

		}

	}

}
