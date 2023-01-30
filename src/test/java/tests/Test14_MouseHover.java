package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MouseHoverPage;

public class Test14_MouseHover extends MouseHoverPage{
	
	Logger logger = LogManager.getLogger(Test14_MouseHover.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/hovers");
		logger.info("The browser opened and navigated to " + URL + "/hovers");
	}

	@Test
	void mouseHover_() {
		mouseHoverAndVerifyInfo();
		logger.info("mouseHover_() Test successfully passed");
	}

}
