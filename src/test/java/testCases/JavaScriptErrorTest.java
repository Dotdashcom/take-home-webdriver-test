package testCases;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.JavaScriptErrorPage;


public class JavaScriptErrorTest extends BaseTest {
	@Test
	public void jsError() {
		HomePage homePage = new HomePage(driver);
		JavaScriptErrorPage jsError = homePage.clickJavaScriptErro();
		LogEntries logs = jsError.checkLogs();
		boolean isUndefinedError = logs.getAll().stream()
				.filter(log -> log.getMessage()
						.contains("Cannot read properties of undefined (reading 'xyz')"))
				.count() > 0;
		assertTrue(isUndefinedError);
	}
}
