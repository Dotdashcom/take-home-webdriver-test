package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class JavaScriptError extends base {
	
	@Test

	public void JavaScriptErrorTest() {
		driver.get(URL + "javascript_error ");
		String ExpectedErrorr = "Cannot read property 'xyz' of undefined";
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry error : logs) {

			assertTrue(error.getMessage().contains(ExpectedErrorr));
//   System.out.println(error.getMessage());
			break;
		}

	}
}
