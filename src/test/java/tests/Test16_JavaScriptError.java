package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptErrorPage;

public class Test16_JavaScriptError extends JavaScriptErrorPage{
	
	Logger logger = LogManager.getLogger(Test16_JavaScriptError.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/javascript_error");
		logger.info("The browser opened and navigated to " + URL + "/javascript_error");
	}

	@Test(priority = -1)
	void javaScriptErrorVerification() {
		javaScriptError("Cannot read properties of undefined");
		logger.info("javaScriptErrorVerification() Test successfully passed");
	}

}
