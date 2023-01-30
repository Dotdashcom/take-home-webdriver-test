package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

public class Test9_DynamicLoading extends DynamicLoadingPage{
	
	Logger logger = LogManager.getLogger(Test9_DynamicLoading.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/dynamic_loading/2");
		logger.info("The browser opened and navigated to " + URL + "/dynamic_loading/2");
	}

	@Test
	void dynamic_loading_() {
		dynamicLoadingUsingExplictWaits();
		logger.info("dynamic_loading_() Test successfully passed");
	}

}
