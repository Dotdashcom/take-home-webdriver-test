package tests;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicContentPage;

public class Test7_DynamicContent extends DynamicContentPage{
	
	Logger logger = LogManager.getLogger(Test7_DynamicContent.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/dynamic_content");
		logger.info("The browser opened and navigated to " + URL + "/dynamic_content");
	}

	@Test
	void dynamic_content_scraping() {
		logger.info("-- Before reload --");
		logger.info(Arrays.toString(getContent().toArray()));
		
		logger.info("-- After reload --");
		logger.info(Arrays.toString(dynamicContAfterReload().toArray()));
		
		assertArraysNotEqual();
		
		logger.info("dynamic_content_scraping() Test successfully passed");
	}

}
