package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IframePage;

public class Test13_IframeTyping extends IframePage{
	
	Logger logger = LogManager.getLogger(Test13_IframeTyping.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/iframe");
		logger.info("The browser opened and navigated to " + URL + "/iframe");
	}

	@Test
	void iframeTyping_() {
		testTypingInIframe();
		logger.info("iframeTyping_() Test successfully passed");
	}

}
