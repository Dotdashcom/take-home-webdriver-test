package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewTabPage;

public class Test17_NewTabPage extends NewTabPage{
	
	Logger logger = LogManager.getLogger(Test17_NewTabPage.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/windows");
		logger.info("The browser opened and navigated to " + URL + "/windows");
	}

	@Test
	void newTabVerification() {
		clickLinkTextAndNavigateToNewTab();
		logger.info("newTabVerification() Test successfully passed");
	}

}
