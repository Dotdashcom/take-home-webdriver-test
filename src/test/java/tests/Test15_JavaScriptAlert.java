package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class Test15_JavaScriptAlert extends JavaScriptAlertsPage{
	
	Logger logger = LogManager.getLogger(Test15_JavaScriptAlert.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/javascript_alerts");
		logger.info("The browser opened and navigated to " + URL + "/javascript_alerts");
	}

	@Test
	void javaScriptsAlertsVerification() {
		clickAndassertAlertBth();
		clickAndassertConfirmBth();
		clickAssertAndTypePromptBth("Test message!");
		logger.info("javaScriptsAlertsVerification() Test successfully passed");
	}

}
