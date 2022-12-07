package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.JavascriptErrorHelper;
public class TestJavascriptError extends TestBase {
	@Test (description = "Test javascript error", dataProvider = "GetTestConfig")
	public void testJavascriptError(Config testConfig) {
		JavascriptErrorHelper javascriptErrorHelper = new JavascriptErrorHelper(testConfig);
		javascriptErrorHelper.verifyJsError("Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')");
	}
}
