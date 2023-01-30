package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlPage;

public class Test8_DynamicControl extends DynamicControlPage{
	
	Logger logger = LogManager.getLogger(Test8_DynamicControl.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/dynamic_controls");
		logger.info("The browser opened and navigated to " + URL + "/dynamic_controls");
	}

	@Test
	void dynamic_controls_() {
		dynamiControlVerificationRemoveAdd();
		logger.info("RemoveAdd() successfully verified");
		dynamiControlVerificationEnableDisable();
		logger.info("EnableDisable() successfully verified");
		logger.info("dynamic_controls_() Test successfully passed");
	}

}
